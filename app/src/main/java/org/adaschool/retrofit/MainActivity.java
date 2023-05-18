package org.adaschool.retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.adaschool.retrofit.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DogApiService dogApiService = RetrofitInstance.getRetrofitInstance().create(DogApiService.class);

        Call<BreedImagesDto> call = dogApiService.getAllImagesFromBreed("terrier");
        call.enqueue(new Callback<BreedImagesDto>() {
            @Override
            public void onResponse(Call<BreedImagesDto> call, Response<BreedImagesDto> response) {
                if (response.isSuccessful()) {
                    List<String> breedImages = response.body().getMessage();
                    loadDogInfo();
                } else {
                    Log.e(TAG, "Error en la respuesta de la API");
                }
            }
            @Override
            public void onFailure(Call<BreedImagesDto> call, Throwable t) {
                Log.e(TAG, "Error al llamar a la API", t);
            }
        });
    }

    private void loadDogInfo() {
        String dogImageUrl = "https://images.dog.ceo/breeds/retriever-chesapeake/n02099849_1830.jpg";
        String dogName = "Terrier";
        binding.textView.setText(dogName);
        Glide.with(this)
                .load(dogImageUrl)
                .into(binding.imageView);
    }


}