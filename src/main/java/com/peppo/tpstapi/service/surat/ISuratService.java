package com.peppo.tpstapi.service.surat;

import com.peppo.tpstapi.entity.User;
import com.peppo.tpstapi.model.request.*;
import com.peppo.tpstapi.model.response.ForListSuratResponse;
import com.peppo.tpstapi.model.response.SuratResponse;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ISuratService {

    void createSurat(
            User user,
            CreateSuratRequest createSuratRequest,
            MultipartFile pdfFile
    );

    Page<ForListSuratResponse> listSuratByYear(
        User user, SearchSuratByYearRequest request
    );

    SuratResponse getSurat(User user, Integer idSurat);

    String updateSurat(
        User user,
        UpdateSuratRequest request,
        MultipartFile pdfFile,
        Integer idSurat
    );

    String deleteSurat(User user, Integer idSurat);

    Integer getTotalActiveSurat();

    Integer getTotalSuratAnTPST();

    List<ForListSuratResponse> getNewestSurat();

    Long getTotalSuratByUser(User user);

    String handleUploadBerkas(User user, Integer idSurat, MultipartFile file);

    Resource handleDownloadBerkas(User user, Integer idSurat);

    Page<ForListSuratResponse> listSuratByDateAndBagian(User user, SearchSuratByDateRequest request);

    String archiveSurats(User user, ArchiveSuratsRequest request);
}
