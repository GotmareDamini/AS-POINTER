package ru.embersoft.expandablecardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout expandableView,expandableView1,expandableView2 ;
    Button arrowBtn,arrowBtn1,arrowBtn2;
    CardView cardView,cardView1,cardView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableView = findViewById(R.id.expandableView);
        arrowBtn = findViewById(R.id.arrowBtn);
        cardView = findViewById(R.id.cardView);

        expandableView1 = findViewById(R.id.expandableView1);
        arrowBtn1 = findViewById(R.id.arrowBtn1);
        cardView1 = findViewById(R.id.cardView1);

        expandableView2 = findViewById(R.id.expandableView2);
        arrowBtn2 = findViewById(R.id.arrowBtn2);
        cardView2 = findViewById(R.id.cardView2);

        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });


        arrowBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView1.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                    expandableView1.setVisibility(View.VISIBLE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView1, new AutoTransition());
                    expandableView1.setVisibility(View.GONE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        arrowBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView2.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    expandableView2.setVisibility(View.VISIBLE);
                    arrowBtn2.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    expandableView2.setVisibility(View.GONE);
                    arrowBtn2.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });
    }
}
