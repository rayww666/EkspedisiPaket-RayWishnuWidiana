/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ekspedisipaket.repository;

import java.util.List;
import com.mycompany.ekspedisipaket.model.Pengiriman;
/**
 *
 * @author Ray Wishnu Widiana
 */
public interface RiwayatRepository {
    
    void simpan(Pengiriman pengiriman);
    
    List<Pengiriman> ambilSemua();
}
