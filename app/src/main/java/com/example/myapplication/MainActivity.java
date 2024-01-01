package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;
        import android.widget.RelativeLayout;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CompoundButton;
        import android.widget.TextView;
        import android.widget.EditText;
        import android.widget.RadioGroup;
        import android.widget.ToggleButton;
        import android.widget.CheckBox;
        import android.widget.ImageView;
        import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    RelativeLayout background;
    TextView textOut;
    Button btnOk;
    Button changeColorButton;
    EditText colorEditText;
    ToggleButton btnToggle;
    ImageView image;
    CheckBox redBox;
    CheckBox greenBox;
    CheckBox blueBox;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = (RelativeLayout) findViewById(R.id.background);
        btnOk = (Button) findViewById(R.id.btnOk);
        changeColorButton = (Button) findViewById(R.id.changeColorButton);
        colorEditText = (EditText) findViewById(R.id.editText);
        btnToggle = (ToggleButton) findViewById(R.id.btnToggle);
        image = (ImageView) findViewById(R.id.img);
        redBox = (CheckBox) findViewById(R.id.redBox);
        greenBox = (CheckBox) findViewById(R.id.greenBox);
        blueBox = (CheckBox) findViewById(R.id.blueBox);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        btnOk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnOk.setText("Нажата");
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    btnOk.setText("Отжата");
                    return true;
                }
                return false;
            }
        });

        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colorHash = colorEditText.getText().toString();
                try {
                    int color = Color.parseColor(colorHash);
                    background.setBackgroundColor(color);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        });



        btnToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    image.setVisibility(View.INVISIBLE);
                } else {
                    image.setVisibility(View.VISIBLE);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton_1) {
                    image.setImageResource(R.drawable.image1);
                } else if (checkedId == R.id.radioButton_2) {
                    image.setImageResource(R.drawable.image2);
                } else if (checkedId == R.id.radioButton_3) {
                    image.setImageResource(R.drawable.image3);
                }
            }
        });

        redBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBackgroundColor();
            }
        });

        greenBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBackgroundColor();
            }
        });

        blueBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBackgroundColor();
            }
        });

    }

    private void updateBackgroundColor() {
        int red = redBox.isChecked() ? 255 : 0;
        int green = greenBox.isChecked() ? 255 : 0;
        int blue = blueBox.isChecked() ? 255 : 0;

        int backgroundColor = Color.rgb(red, green, blue);
        background.setBackgroundColor(backgroundColor);
    }
}