package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class PlayAudio4 extends Service {

    static MediaPlayer mCurrentPlayer4;
    static MediaPlayer mNextPlayer4 = null;

    static float volume4 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        LoopMediaPlayer4.create(this, R.raw.chill);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio4.mCurrentPlayer4.stop();
        PlayAudio4.mCurrentPlayer4.release();
        PlayAudio4.mNextPlayer4.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer4 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new LoopMediaPlayer4(context, resId);
        }

        private LoopMediaPlayer4(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer4 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer4.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer4.start();
                mCurrentPlayer4.setVolume(volume4,volume4);
            });

            createNextMediaPlayer4();
        }

        private void createNextMediaPlayer4() {
            mNextPlayer4 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer4.setNextMediaPlayer(mNextPlayer4);
            mCurrentPlayer4.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer4) {
                mediaPlayer4.release();
                mCurrentPlayer4 = mNextPlayer4;
                mCurrentPlayer4.setVolume(volume4,volume4);

                createNextMediaPlayer4();
            }
        };
    }



}
