package com.example.gauss.modularbeit;

import java.util.ArrayList;
import java.util.List;

/**
 * Meshes holds a list with Mesh, the pattern is a Singleton
 */
public class Meshes {
    private List<Mesh> meshes;
    private static Meshes instance = null;

    public static Meshes instance() {
        if (instance == null)
            instance = new Meshes();

        return instance;
    }

    private Meshes(){
        meshes = new ArrayList<>();
    }

    public List<Mesh> getMeshes() {
        return meshes;
    }

    public boolean add(Mesh mesh) {
        meshes.add(mesh);
        return true;
    }

    public int size() {
        return meshes.size();
    }

    public Mesh get(int i) {
        return meshes.get(i);
    }
}
