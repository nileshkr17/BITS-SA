package com.bits.sa;



import controller.LibraryController;
import model.LibraryModel;
import view.LibraryView;

public class MVC {
    public static void main(String[] args) {
        LibraryModel model = new LibraryModel();
        LibraryView view = new LibraryView();
        LibraryController libController = new LibraryController(model, view);
        libController.start();
    }
}
