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

    /**
     * The list of Mesh with Objects will be converted to Mesh with Strings
     * @return
     */
    public List<String> getMeshesAsStings() {
        List<String> meshesString = new ArrayList<>(meshes.size());
        for(Mesh mesh : meshes){
            meshesString.add(mesh.toString());
        }
        return meshesString;
    }

    /**
     * A list with the different mesh type (meshId) will be extracted from meshes
     * @return
     */
    public List<String> getMeshesAsStringGroup(){
        List<String> meshesStringGroup = new ArrayList<>();
        String meshGroupItem = Meshes.instance().getMesh(0).getMeshId();
        meshesStringGroup.add(meshGroupItem);
        for (Mesh mesh : meshes){
            if(!meshGroupItem.equals(mesh.getMeshId())){
                meshesStringGroup.add(mesh.getMeshId());
                meshGroupItem = mesh.getMeshId();
            }
        }
        return meshesStringGroup;
    }

    /**
     * A list with diffent mesh form the same typ will be returned
     * @param groupEntry is the meshId of a mesh typ
     * @return
     */
    public List<String > getMeshesAsStringItem(String groupEntry){
        List<String> meshesStringItem = new ArrayList<>();
        for (Mesh mesh : meshes){
            if(!groupEntry.equals(mesh.getMeshId())){
                meshesStringItem.add(mesh.toString());
            }
        }
        return meshesStringItem;
    }

    public boolean add(Mesh mesh) {
        meshes.add(mesh);
        return true;
    }

    public int size() {
        return meshes.size();
    }

    public Mesh getMesh(int i) {
        return meshes.get(i);
    }
}
