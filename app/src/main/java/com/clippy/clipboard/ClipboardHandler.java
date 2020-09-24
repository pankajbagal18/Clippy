package com.clippy.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;

import static android.content.Context.CLIPBOARD_SERVICE;

public class ClipboardHandler {
    final private String TAG_CLIPBOARD_HANDLER = "ClipboardHandler";
    private Context context;

    public ClipboardHandler(Context context) {
        this.context = context;
    }

    public void saveClip() {
        Log.i(TAG_CLIPBOARD_HANDLER, "Saving clip");
        final ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
        clipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                ClipData clipData = clipboardManager.getPrimaryClip();
                Log.i(TAG_CLIPBOARD_HANDLER, "Text if any " + clipData.getItemAt(0).getText().toString());
            }
        });
        Log.i(TAG_CLIPBOARD_HANDLER, "Saved clip");
    }
}
