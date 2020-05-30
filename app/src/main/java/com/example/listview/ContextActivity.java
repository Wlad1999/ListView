package com.example.listview;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContextActivity extends AppCompatActivity {
TextView title;
TextView sub;
ImageView car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        //Плучаем доступ к объектам
        title = findViewById(R.id.mainText);
        sub = findViewById(R.id.subText);
        car = findViewById(R.id.car);

        //Будем принимать значения
        Intent intent = getIntent();

        //Получаем значения из onItemClick
        title.setText(intent.getStringExtra("Car"));
        sub.setText(intent.getStringExtra("Position"));
        car.setImageResource(intent.getIntExtra("Picture",0));
    }
}


