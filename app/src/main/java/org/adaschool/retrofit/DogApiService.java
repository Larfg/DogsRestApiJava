package org.adaschool.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogApiService {
    @GET("api/breeds/list/all")
    Call<BreedsListDto> getAllBreeds();

    @GET("api/breed/{breed}/images")
    Call<BreedImagesDto> getAllImagesFromBreed(@Path("breed") String breed);
}