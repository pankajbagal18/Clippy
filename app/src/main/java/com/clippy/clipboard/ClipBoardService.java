package com.clippy.clipboard;

import android.app.Service;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ClipBoardService extends Service {

    final private String TAG_CLIP_BOARD = "CLIP_BOARD";

    private ClipboardManager.OnPrimaryClipChangedListener clipChangedListener = () -> performCopying();

    private void performCopying() {
        Log.i(TAG_CLIP_BOARD, "started copying");
        Toast.makeText(this, "Copied This", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate() {
        ((ClipboardManager) getSystemService(CLIPBOARD_SERVICE)).addPrimaryClipChangedListener(clipChangedListener);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG_CLIP_BOARD, "service started");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
