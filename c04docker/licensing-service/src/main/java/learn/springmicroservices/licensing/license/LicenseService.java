package learn.springmicroservices.licensing.license;

import learn.springmicroservices.licensing.model.License;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    private final MessageSource messages;

    public LicenseService(MessageSource messageSource) {
        this.messages = messageSource;
    }

    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("LearningStock");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            String formatMessage = messages.getMessage("license.create.message", null, locale);
            responseMessage = String.format(formatMessage, license.toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            String formatMessage = messages.getMessage("license.update.message", null, locale);
            responseMessage = String.format(formatMessage, license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId, Locale locale) {
        String formatMessage = messages.getMessage("license.delete.message", null, locale);
        return String.format(formatMessage, licenseId, organizationId);
    }
}
