package org.beta.vibing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class PlayAudio9 extends Service {
    static MediaPlayer mCurrentPlayer9;
    static MediaPlayer mNextPlayer9 = null;

    static float volume9 = 1;

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        PlayAudio9.LoopMediaPlayer9.create(this, R.raw.waves);

        return START_STICKY;
    }

    public void onDestroy() {
        PlayAudio9.mCurrentPlayer9.stop();
        PlayAudio9.mCurrentPlayer9.release();
        PlayAudio9.mNextPlayer9.release();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }

    private static class LoopMediaPlayer9 {

        private final Context mContext;
        private final int mResId;

        private static void create(Context context, int resId) {
            new PlayAudio9.LoopMediaPlayer9(context, resId);
        }

        private LoopMediaPlayer9(Context context, int resId) {
            mContext = context;
            mResId = resId;

            mCurrentPlayer9 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer9.setOnPreparedListener(mediaPlayer -> {
                mCurrentPlayer9.start();
                mCurrentPlayer9.setVolume(volume9,volume9);
            });

            createNextMediaPlayer9();
        }

        private void createNextMediaPlayer9() {
            mNextPlayer9 = MediaPlayer.create(mContext, mResId);
            mCurrentPlayer9.setNextMediaPlayer(mNextPlayer9);
            mCurrentPlayer9.setOnCompletionListener(onCompletionListener);
        }

        private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer9) {
                mediaPlayer9.release();
                mCurrentPlayer9 = mNextPlayer9;
                mCurrentPlayer9.setVolume(volume9,volume9);

                createNextMediaPlayer9();
            }
        };
    }
}
