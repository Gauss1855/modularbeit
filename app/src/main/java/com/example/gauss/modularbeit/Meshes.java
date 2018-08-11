package com.example.gauss.modularbeit;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Meshes {
    private List<Mesh> meshes;

    public Meshes(){
        meshes = new ArrayList<>();
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
