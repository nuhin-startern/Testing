package xyz.sheba.movieticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import xyz.sheba.demofeature.ViaMedia;
import xyz.sheba.movieticketcommon.api.SpRefferApi;
import xyz.sheba.movieticketcommon.api.SpRefferCallback;
import xyz.sheba.movieticketcommon.model.prefertime.PreferTime;
import xyz.sheba.movieticketcommon.model.prefertime.Time;
import xyz.sheba.preference.AppPreferenceHelper;

public class MainActivity extends AppCompatActivity {

    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTest = findViewById(R.id.tvTest);

        SpRefferApi api = new SpRefferApi(this);
        final AppPreferenceHelper appPreferenceHelper = new AppPreferenceHelper(this);

        api.getAllCategoriesData(new SpRefferCallback.categoriesCallBack() {
            @Override
            public void onSuccess(PreferTime allCategories) {
                Log.e("api ", allCategories.toString());
                appPreferenceHelper.setTopUpSettings(allCategories);
            }

            @Override
            public void onError(String msg, int code) {
                Log.e("api ", "fff");
            }

            @Override
            public void onFailed(String msg) {
                Log.e("api ", "gg");
            }
        });

        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, appPreferenceHelper.getTopUpSettings().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
