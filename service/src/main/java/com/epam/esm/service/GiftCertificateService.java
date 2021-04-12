package com.epam.esm.service;

import com.epam.esm.model.GiftCertificate;
import com.epam.esm.service.exception.ServiceException;
import com.epam.esm.service.request.CertificateRequestBody;

import java.util.List;

public interface GiftCertificateService {

    GiftCertificate getGiftCertificate(String name) throws ServiceException;
    GiftCertificate getGiftCertificate(int id) throws ServiceException;
    List<GiftCertificate> geAllCertificates() throws ServiceException;
    List<GiftCertificate> getGiftCertificatesByContent(String content) throws ServiceException;
    List<GiftCertificate> getGiftCertificateByTagName(String tagName) throws ServiceException;
    List<GiftCertificate> getAllGiftCertificatesSortedByName(boolean isAscending) throws ServiceException;
    List<GiftCertificate> getAllGiftCertificatesSortedByDate(boolean isAscending) throws ServiceException;
    List<GiftCertificate> getGiftCertificates(CertificateRequestBody requestBody) throws ServiceException;

    GiftCertificate addGiftCertificate(GiftCertificate giftCertificate) throws ServiceException;
    void deleteGiftCertificate(int id) throws ServiceException;
    GiftCertificate updateGiftCertificate(GiftCertificate giftCertificate, int id) throws ServiceException;
}
