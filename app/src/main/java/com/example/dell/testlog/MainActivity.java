package com.example.dell.testlog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> stringList;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: MaiinAcivity DEBUG");
        Log.e(TAG, "onCreate: MaiinAcivity ERROR");
        Log.w(TAG, "onCreate: MaiinAcivity WARNING");
        Log.i(TAG, "onCreate: MaiinAcivity INFORMATION");
        Log.v(TAG, "onCreate: MaiinAcivity VERBOSE");
        findViewById(R.id.btnPicFile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("image/*");
                chooseFile.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(Intent.createChooser(chooseFile, "Choose a file"), 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult: " + requestCode);
        Log.e(TAG, "onActivityResult: " + data.getData());
    }
}
