package view.edit.input.bottomdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = findViewById(R.id.show);
        showDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show:
                openDialog();
                break;
        }
    }

    private void openDialog() {
        DialogPlus dialog = DialogPlus.newDialog(this)
                .setContentHolder(new ViewHolder(R.layout.item_list))
//                .setExpanded(true, 300)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(DialogPlus dialog, View view) {
                        if (view instanceof TextView) {
                            Toast.makeText(MainActivity.this,
                                    ((TextView)view).getText().toString(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .create();
        dialog.show();
    }
}
