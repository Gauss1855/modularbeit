package com.example.gauss.modularbeit;

import java.util.List;

public class MeshesErrorMessages {
    private List<ErrorMessage> errorMessages;
    private static ErrorMessages instanceErrorMessages = null;
    private List<Mesh> meshes;
    private static Meshes instanceMeshes = null;

    public static Meshes instanceMeshes() {
        if (instanceMeshes == null)
            instanceMeshes = new Meshes();

        return instanceMeshes;
    }
}
