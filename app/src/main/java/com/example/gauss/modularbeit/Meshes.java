package com.example.gauss.modularbeit;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Meshes {
    private List<Mesh> meshes;
    private static Meshes instance = null;

    public static Meshes instance() {
        if (instance == null)
            instance = new Meshes();

        return instance;
    }

    protected Meshes(){
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
