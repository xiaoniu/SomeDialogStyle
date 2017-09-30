package com.example.ast.mydialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ast.mydialogfragment.dialogfragment.GiftDialogFragment;
import com.example.ast.mydialogfragment.dialogfragment.PermissionDialogFragment;
import com.example.ast.mydialogfragment.dialogfragment.UpdateDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialogFragment updateDialogFragment = new UpdateDialogFragment();
                updateDialogFragment.show(getSupportFragmentManager(), "update");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionDialogFragment permissionDialogFragment = new PermissionDialogFragment();
                permissionDialogFragment.show(getSupportFragmentManager(), "permission");
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GiftDialogFragment giftDialogFragment = new GiftDialogFragment();
                giftDialogFragment.show(getSupportFragmentManager(), "gift");
            }
        });

    }
}
