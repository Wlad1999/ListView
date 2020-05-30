package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Создаем наши элементы
    String[] mainsTitle = {"BMW", "AUDI", "Mercedes"};
    String[] subsTitle = {"BMW is the first", "Audi is the second", "Mercedes is the third"};
    int[] carImages = new int[]{R.drawable.bmw, R.drawable.audi, R.drawable.mercedes};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listView);
        // Создаем объект адаптера
        MyAdapter adapter = new MyAdapter();
        // Передаем его виджету списка
        listView.setAdapter(adapter);

        //Налажываем отклик программы на нажатие по объекту из списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),ContextActivity.class);
                //Передаем значения в ContextActivity
                i.putExtra("Car",mainsTitle[position]);
                i.putExtra("Position",subsTitle[position]);
                i.putExtra("Picture",carImages[position]);
                //Запускаем ContextActivity
                startActivity(i);
            }
        });
    }

    //Создаем адаптер который будет унаследовать методы BaseAdapter
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return carImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // 1. Преобразуем макет в дерево объектов
            convertView = getLayoutInflater().inflate(R.layout.list_item,null);

            // 2. Получаем доступ к виджетам дерева объектов
            ImageView cars =(ImageView) convertView.findViewById(R.id.images);
            TextView titles = (TextView)convertView.findViewById(R.id.mainTitle);
            TextView subs = (TextView)convertView.findViewById(R.id.subTitle);

            // 3. Меняем содержимое виджетов
            cars.setImageResource(carImages[position]);
            titles.setText(mainsTitle[position]);
            subs.setText(subsTitle[position]);

            // 4. Возвращаем модифицированное дерево объектов
            return convertView;
        }
    }
}


