package ai.trueface.demo;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import ai.trueface.sdk.Trueface;
import ai.trueface.sdk.models.SpoofDetection;
import ai.trueface.sdk.models.SpoofDetectionRequest;
import io.github.kbiakov.codeview.CodeView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpActivity extends AppCompatActivity {

    CodeView codeView;
    AppCompatImageView image;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spoof_detection);

        codeView = findViewById(R.id.codeview);
        result = findViewById(R.id.result);
        image = findViewById(R.id.image);

        AppCompatButton btn = findViewById(R.id.from_gallery);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri code = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Intent intent = new Intent(Intent.ACTION_PICK, code);
                startActivityForResult(intent, 3);
            }
        });
    }

    public static byte[] getBytesFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        return buffer.toByteArray();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        InputStream inputStream;
        try {
            inputStream = getApplicationContext().getContentResolver().openInputStream(data.getData());
            byte[] bytes = getBytesFromInputStream(inputStream);

            image.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
            String base64 = Base64.encodeToString(bytes, Base64.DEFAULT);

            result.setText(getString(R.string.processing));

            SpoofDetectionRequest request = new SpoofDetectionRequest();
            request.setImg(base64);

            Call<SpoofDetection> call = Trueface.endPoints.spoofDetection(request);
            call.enqueue(new Callback<SpoofDetection>() {
                @Override
                public void onResponse(Call<SpoofDetection> call, Response<SpoofDetection> response) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String json = gson.toJson(response);

                    if (response.isSuccessful() && response.body() != null) {
                        if (response.body().getSuccess()) {
                            result.setText(getString(R.string.result_success));
                            codeView.setCode(json);
                        } else {
                            result.setText(response.body().getMessage());
                        }
                    } else {
                        result.setText(response.errorBody().toString());
                    }
                }

                @Override
                public void onFailure(Call<SpoofDetection> call, Throwable t) {
                    result.setText(t.getMessage());
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
