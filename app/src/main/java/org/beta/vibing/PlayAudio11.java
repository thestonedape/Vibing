package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class PlayAudio11 extends Service {

    static MediaPlayer mCurrentPlayer11;
    static MediaPlayer mNextPlayer11 = null;

    static float volume11 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        PlayAudio11.LoopMediaPlayer11.create(this, R.raw.guitar);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio11.mCurrentPlayer11.stop();
        PlayAudio11.mCurrentPlayer11.release();
        PlayAudio11.mNextPlayer11.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer11 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new PlayAudio11.LoopMediaPlayer11(context, resId);
        }

        private LoopMediaPlayer11(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer11 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer11.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer11.start();
                mCurrentPlayer11.setVolume(volume11,volume11);
            });

            createNextMediaPlayer11();
        }

        private void createNextMediaPlayer11() {
            mNextPlayer11 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer11.setNextMediaPlayer(mNextPlayer11);
            mCurrentPlayer11.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer11) {
                mediaPlayer11.release();
                mCurrentPlayer11 = mNextPlayer11;
                mCurrentPlayer11.setVolume(volume11,volume11);

                createNextMediaPlayer11();
            }
        };
    }
}
