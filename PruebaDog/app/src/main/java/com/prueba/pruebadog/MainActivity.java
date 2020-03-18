package com.prueba.pruebadog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.prueba.pruebadog.adapters.DogListAdapter;
import com.prueba.pruebadog.fragments.DogListFragment;
import com.prueba.pruebadog.model.BreedListResponse;
import com.prueba.pruebadog.retrofit.DogApi;
import com.prueba.pruebadog.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> responseApi =new ArrayList<String>();
    private RecyclerView rViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DogApi service = RetrofitClient.getRetrofitInstance().create(DogApi.class);
        Call<BreedListResponse>call =service.getBreedListApi();
        call.enqueue(new Callback<BreedListResponse>() {
            @Override
            public void onResponse(Call<BreedListResponse> call, Response<BreedListResponse> response) {
                Log.i("dogs","responde");
                responseApi=response.body().getBreedList();
                for(String a : responseApi){
                    Log.i("dogs", " a: " + a);
                }
                initFragment();


            }

            @Override
            public void onFailure(Call<BreedListResponse> call, Throwable t) {
                failureToast();
            }
        });




    }

    public void initFragment(){

        DogListFragment detailFragment = DogListFragment.initFragment(responseApi);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayoutMain, detailFragment, "DetailFragment")
                .commit();
    }

    public void failureToast(){
        Toast.makeText(MainActivity.this,"cagaste",Toast.LENGTH_SHORT).show();
    }
}
