package com.yunyan.toybricks.service.zip;

import android.content.Context;
import android.content.Intent;

import com.yunyan.toybricks.entity.ToyBricksZipFile;
import com.yunyan.toybricks.utils.Const;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by George on 2015/8/31.
 */
public class UnZipTask {
    private Context context=null;
    private ToyBricksZipFile file=null;
    /**
     * 线程池
     */
    public static final ExecutorService sExecutorService = Executors.newCachedThreadPool();

    public UnZipTask(Context context,ToyBricksZipFile file){
        this.context=context;
        this.file=file;
    }
    public void UnZip(){
        ZipThread zipThread=new ZipThread(file);
        sExecutorService.execute(zipThread);
    }
    class ZipThread extends Thread{
        private ToyBricksZipFile mToyBricksZipFile;
        private ZipFile zip;
        private ProgressMonitor progressMonitor;
        public ZipThread(ToyBricksZipFile mToyBricksZipFile){
            this.mToyBricksZipFile=mToyBricksZipFile;
        }
        @Override
        public void run() {
            try {
                zip=new ZipFile(new File(mToyBricksZipFile.getFilePath()));
                zip.setFileNameCharset("GBK");
                zip.setRunInThread(true);
                zip.extractAll(mToyBricksZipFile.getExtractPath());
                if (!zip.isValidZipFile()){
                    throw new ZipException("ZipException");
                }
                if (zip.isEncrypted()){
                    zip.setPassword(mToyBricksZipFile.getPassword());
                }
                progressMonitor=zip.getProgressMonitor();
                long time = System.currentTimeMillis();
                while (!(progressMonitor.getTotalWork()==progressMonitor.getWorkCompleted())){
                        //发送解压进度广播
                    if (System.currentTimeMillis() - time > (1 * 1000) ) {
                        Intent intent =new Intent(UnZipService.UNZIP_ACTION_UPDATE);
                        intent.putExtra(Const.UNZIP_PROGRESS, progressMonitor.getPercentDone());
                        context.sendBroadcast(intent);
                       // Log.e(UnZipTask.class.getSimpleName(), "解压进度：" + progressMonitor.getPercentDone() + "   K: " + progressMonitor.getWorkCompleted() + " L: " + progressMonitor.getTotalWork());
                       // Log.e(UnZipTask.class.getSimpleName(),"getState: "+progressMonitor.getState()+"  RESULT_SUCCESS:"+progressMonitor.RESULT_SUCCESS);
                    }
                    //解压结束
                    if (progressMonitor.getState()==progressMonitor.RESULT_SUCCESS){
                        //发送解压结束广播
                        Intent intent =new Intent(UnZipService.UNZIP_ACTION_FINISH);
                        intent.putExtra(Const.UNZIP_SUCCESS,"unzip_success");
                        context.sendBroadcast(intent);
                        break;
                    }
                    //解压错误
                    if (progressMonitor.getState()==progressMonitor.RESULT_ERROR){
                        throw new ZipException("ZipException");
                    }
                    //取消解压
                    if (progressMonitor.getState()==progressMonitor.RESULT_CANCELLED){

                    }
                }

            }catch (ZipException z){
                //发送解压异常广播
                Intent intent =new Intent(UnZipService.UNZIP_ACTION_EXCEPTION);
                intent.putExtra(Const.UNZIP_ZIPEXCEPTION,"unzip_zipexception");
                context.sendBroadcast(intent);
            }finally {
               // 结束删除zip源文件
                if (mToyBricksZipFile.getDelete()){
                    new File(mToyBricksZipFile.getFilePath()).delete();
                }
            }
        }
    }
}
