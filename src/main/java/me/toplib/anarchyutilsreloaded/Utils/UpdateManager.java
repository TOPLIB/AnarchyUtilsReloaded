package me.toplib.anarchyutilsreloaded.Utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.toplib.anarchyutilsreloaded.AnarchyUtilsReloaded;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UpdateManager {

    public static String getCurrentVersion() {
        return AnarchyUtilsReloaded.getInstance().getDescription().getVersion();
    }

    public static String getLatestVersion() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.github.com/repos/TOPLIB/anarchyutils/releases/latest"))
                .GET()
                .build();

        String body = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
        JsonObject json = new JsonParser().parse(body).getAsJsonObject();

        return json.get("name").getAsString();
    }

    public static boolean hasUpdate() throws URISyntaxException, IOException, InterruptedException {
        return !getCurrentVersion().equals(getLatestVersion());
    }
}
