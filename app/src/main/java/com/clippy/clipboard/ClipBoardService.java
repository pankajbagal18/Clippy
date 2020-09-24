package com.clippy.clipboard;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class ClipBoardService extends IntentService {

    final private String TAG_CLIP_BOARD = "CLIP_BOARD";
    private ClipboardHandler clipboardHandler;
    private Context context;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ClipBoardService(Context context, String name) {
        super(name);
        this.context = context;
    }

    public ClipBoardService() {
        super("Clip Board Service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG_CLIP_BOARD, "service started");
        ClipboardHandler clipboardHandler = new ClipboardHandler(this);
        clipboardHandler.saveClip();
        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String dataString = intent.getDataString();
        Log.i(TAG_CLIP_BOARD, "work data string " + dataString);
    }
}
