package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;




public class PlayAudio3 extends Service {

    static MediaPlayer mCurrentPlayer3;
    static MediaPlayer mNextPlayer3 = null;

    static float volume3 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        LoopMediaPlayer3.create(this, R.raw.waterfall);

        return START_STICKY ;
    }

    public void onDestroy() {
        PlayAudio3.mCurrentPlayer3.stop();
        PlayAudio3.mCurrentPlayer3.release();
        PlayAudio3.mNextPlayer3.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer3 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new LoopMediaPlayer3(context, resId);
        }

        private LoopMediaPlayer3(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer3 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer3.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer3.start();
                mCurrentPlayer3.setVolume(volume3,volume3);
            });

            createNextMediaPlayer3();
        }

        private void createNextMediaPlayer3() {
            mNextPlayer3 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer3.setNextMediaPlayer(mNextPlayer3);
            mCurrentPlayer3.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer3) {
                mediaPlayer3.release();
                mCurrentPlayer3 = mNextPlayer3;
                mCurrentPlayer3.setVolume(volume3,volume3);

                createNextMediaPlayer3();
            }
        };
    }

}