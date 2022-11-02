package learn.springmicroservices.licensing.license;

import learn.springmicroservices.licensing.config.ServiceConfig;
import learn.springmicroservices.licensing.model.License;
import learn.springmicroservices.licensing.respository.LicenseRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LicenseService {

    private final MessageSource messages;
    private final LicenseRepository licenseRepository;
    private final ServiceConfig serviceConfig;

    public LicenseService(MessageSource messageSource, LicenseRepository licenseRepository, ServiceConfig serviceConfig) {
        this.messages = messageSource;
        this.licenseRepository = licenseRepository;
        this.serviceConfig = serviceConfig;
    }

    public License getLicense(String licenseId, String organizationId) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if (license == null) {
            throw new IllegalArgumentException(String.format(
                    messages.getMessage("license.search.error.message", null, null),
                    licenseId, organizationId));
        }
        return license.withComment(serviceConfig.getProperty());
    }

    public License createLicense(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
        licenseRepository.save(license);
        return license.withComment(serviceConfig.getProperty());
    }

    public License updateLicense(License license) {
        licenseRepository.save(license);
        return license.withComment(serviceConfig.getProperty());
    }

    public String deleteLicense(String licenseId) {
        licenseRepository.deleteById(licenseId);
        String formatMessage = messages.getMessage("license.delete.message", null, null);
        return String.format(formatMessage, licenseId);
    }
}
