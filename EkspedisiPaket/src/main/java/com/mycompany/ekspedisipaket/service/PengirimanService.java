package com.mycompany.ekspedisipaket.service;

import com.mycompany.ekspedisipaket.layanan.BisaDiasuransikan;
import com.mycompany.ekspedisipaket.layanan.LayananPengiriman;
import com.mycompany.ekspedisipaket.model.Pengiriman;
import com.mycompany.ekspedisipaket.repository.RiwayatRepository;
import java.util.List;

/**
 *
 * @author Ray Wishnu Widiana
 */
public class PengirimanService {

    private final RiwayatRepository repository;

    public PengirimanService(RiwayatRepository repository) {
        this.repository = repository;
    }

    public Pengiriman kirim(String penerima, double berat,
            LayananPengiriman layanan, boolean pakaiAsuransi) {

        if (penerima == null || penerima.isBlank()) {
            throw new IllegalArgumentException("Nama penerima wajib diisi");
        }

        if (!Double.isFinite(berat) || berat <= 0) {
            throw new IllegalArgumentException("Berat harus lebih dari 0 kg");
        }

        double total = layanan.hitungOngkir(berat);
        boolean asuransiDipakai = false;

        if (pakaiAsuransi && layanan instanceof BisaDiasuransikan asuransi) {
            total += asuransi.getBiayaAsuransi();
            asuransiDipakai = true;
        }

        Pengiriman pengiriman = new Pengiriman(
                penerima.trim(),
                layanan.getNama(),
                berat,
                asuransiDipakai,
                total);

        repository.simpan(pengiriman);
        return pengiriman;
    }
    public List<Pengiriman> ambilRiwayat(){
        return repository.ambilSemua();
    }
}