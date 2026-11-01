package com.mycompany.ekspedisipaket.repository;

import com.mycompany.ekspedisipaket.model.Pengiriman;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ray Wishnu Widiana
 */
public class RiwayatArrayList implements RiwayatRepository {
    
    private final List<Pengiriman> daftar = new ArrayList<>(); 
    
    @Override
    public void simpan(Pengiriman pengiriman) {
        daftar.add(pengiriman);
    }
    
    @Override
    public List<Pengiriman> ambilSemua() {
        return List.copyOf(daftar);
    }
}