package com.example.demo.exception;

@SuppressWarnings("checkstyle:linelength")
public final class ValidationConstraints {

    public static final String NAME_IS_REQUIRED = "Name is required";
    public static final String ORIGINAL_NAME_IS_REQUIRED = "Original Name is required";
    public static final String PARTNER_CODE_IS_REQUIRED = "Partner code is required";
    public static final String CNPJ_IS_REQUIRED = "CNPJ is required";
    public static final String CONTRACT_NUMBER_IS_REQUIRED = "Contract number is required";
    public static final String EMAIL_IS_REQUIRED = "Email is required";
    public static final String CPF_IS_REQUIRED = "CPF is required";
    public static final String PHONE_IS_REQUIRED = "Phone is required";
    public static final String POSITION_IS_REQUIRED = "Position is required";
    public static final String STATUS_IS_REQUIRED = "Status is required";
    public static final String COMMUNICATION_TYPE_IS_REQUIRED = "Communication type is required";
    public static final String POINT_TYPE_IS_REQUIRED = "Point type is required";
    public static final String URL_PATH_IS_REQUIRED = "URL path is required";
    public static final String CAMPAIGN_IS_REQUIRED = "Campaign is required";
    public static final String CAMPAIGN_TYPE_IS_REQUIRED = "Campaign type is required";
    public static final String DESCRIPTION_IS_REQUIRED = "Description is required";
    public static final String START_DATE_IS_REQUIRED = "Start date is required";
    public static final String END_DATE_IS_REQUIRED = "End date is required";
    public static final String CUSTOMER_POINTS_IS_REQUIRED = "Customer points is required";
    public static final String FILE_SIZE_IS_REQUIRED = "File size is required";
    public static final String INDICATED_POINTS_IS_REQUIRED = "Indicated points is required";
    public static final String FIELD_IS_REQUIRED = "Field is required";
    public static final String DELETED_REQUIRED = "Deleted is required";
    public static final String SECTOR_CODE_IS_REQUIRED = "Sector code is required";
    public static final String INDICATION_QUANTITY_ALLOWED_IS_REQUIRED = "Indication quantity allowed is required";
    public static final String EXTENSION_IS_REQUIRED = "Extension is required";
    public static final String PROCESSED_IS_REQUIRED = "Processed is required";
    public static final String FILE_TYPE_IS_REQUIRED = "File type is required";
    public static final String LINE_NUMBER_IS_REQUIRED = "Line number is required";

    public static final String NAME_SIZE_MUST_BE_BETWEEN = "Name size must be between {min} and {max} characters long";
    public static final String PARTNER_URL_SIZE_MUST_BE_BETWEEN =
            "Partner Url size must be between {min} and {max} characters long";
    public static final String PARTNER_CODE_SIZE_MUST_BE_BETWEEN =
            "Partner code size must be between {min} and {max} characters long";
    public static final String CNPJ_SIZE_MUST_BE_BETWEEN = "CNPJ size must be between {min} and {max} characters long";
    public static final String URL_PATH_SIZE_MUST_BE_BETWEEN =
            "URL path size must be between {min} and {max} characters long";
    public static final String DESCRIPTION_SIZE_MUST_BE_BETWEEN =
            "Description size must be between {min} and {max} characters long";
    public static final String EXTENSION_SIZE_MUST_BE_BETWEEN =
            "Extension size must be between {min} and {max} characters long";
    public static final String LINK_SIZE_MUST_BE_BETWEEN = "Link size must be between {min} and {max} characters long";

    public static final String CAMPAIGN_SIZE_MUST_BE_BETWEEN =
            "Campaign size must be between {min} and {max} characters long";
    public static final String VALUE_SIZE_MUST_BE_BETWEEN =
            "Value size must be between {min} and {max} characters long";

    public static final String PHOTO_URL_MAX_SIZE_IS = "Max Photo URL size is {max}";
    public static final String EMAIL_MAX_SIZE_IS = "Max Email size is {max}";
    public static final String CPF_MAX_SIZE_IS = "Max CPF size is {max}";
    public static final String PHONE_MAX_SIZE_IS = "Max Phone size is {max}";
    public static final String POSITION_MAX_SIZE_IS = "Max position size is {max}";
    public static final String POSTAL_CODE_MAX_SIZE_IS = "Max Postal code size is {max}";
    public static final String HASH_CODE_MAX_SIZE_IS = "Max Hash code size is {max}";
    public static final String POINT_TYPE_MAX_SIZE_IS = "Max Point type size is {max}";
    public static final String SECTOR_CODE_MAX_SIZE_IS = "Max Sector code size is {max}";
    public static final String CONTRACT_NUMBER_MAX_SIZE_IS = "Max Contract number size is {max}";

    public static final String INVALID_CNPJ = "CNPJ invalid : ${validatedValue}";
    public static final String INVALID_URL = "URL invalid : ${validatedValue}";
    public static final String INVALID_EMAIL = "Invalid Email : ${validatedValue}";
    public static final String INVALID_CPF = "Invalid CPF : ${validatedValue}";
    public static final String INVALID_CAMPAIGN_STATUS = "Invalid Communication Type : ${validatedValue}";
    public static final String INVALID_COMMUNICATION_TYPE = "Invalid Communication Type : ${validatedValue}";
    public static final String INVALID_SPECIAL_CHARACTERS_CPF = "Invalid Non-Numeric CPF : ${validatedValue}";
    public static final String INVALID_SPECIAL_CHARACTERS_PHONE = "Invalid Non-Numeric Phone : ${validatedValue}";
    public static final String INVALID_SPECIAL_CHARACTERS_POSTAL_CODE =
            "Invalid Non-Numeric Postal Code : ${validatedValue}";
    public static final String INVALID_SPECIAL_CHARACTERS_CNPJ = "Invalid Non-Numeric CNPJ : ${validatedValue}";

    public static final String START_DATE_GREATER_THAN_END_DATE = "Start date cannot be greater than end date";
    public static final String START_DATE_AND_END_DATE_CANNOT_BE_THE_SAME_TODAY =
            "Start and end date cannot be the same as today";

    public static final String END_DATE_LESS_THAN_CURRENT_DATE = "End date cannot be less than current date";
    public static final String EMAIL_ID_NEGATIVE = "Email ID cannot be negative";

    public static final String CAMPAIGN_ALREADY_EXISTS = "Campaign with urlPath {} already been created";
    public static final String CAMPAIGN_ALREADY_DELETED = "Campaign with urlPath {} already been deleted";
    public static final String CAMPAIGN_ALREADY_EXPIRED = "Campaign with urlPath {} already been expired";
    public static final String CAMPAIGN_NOT_FOUND = "Campaign with urlPath {} not found";
    public static final String DRAFT_NOT_FOUND = "Campaign's Draft not found";
    public static final String CAMPAIGN_AND_PARTNER_CODE_PRE_CONDITION =
            "Campaign with urlPath {0} not acessible for partnerCode {1}";
    public static final String CUSTOMER_NOT_ELIGIBLE = "Customer with cpf {} is not eligible";
    public static final String END_DATE_CANNOT_BE_DECREASED = "End date cannot be decreased";
    public static final String INDICATION_ALREADY_USED = "Indication with hash code {} already been used";
    public static final String INDICATION_NOT_FOUND = "Indication with hash code {} not found";
    public static final String JSON_CONVERT_ERROR = "Failed to convert object in json string";
    public static final String MESSAGE_SEND_ERROR = "Error sending {} notification";
    public static final String PARTNER_ALREADY_EXISTS = "Partner with cnpj {0} or partnerCode {1} already been created";
    public static final String PARTNER_NOT_FOUND = "Partner code {} not found";
    public static final String ONLINE_CAMPAIGN_WITHOUT_PARTNER_URL = "Invalid Partner Url {} for online campaign";

    public static final int CPF_SIZE = 11;
    public static final int CNPJ_SIZE = 14;

    public static final int CAMPAIGN_NAME_MAX_SIZE = 30;
    public static final int CAMPAIGN_NAME_MIN_SIZE = 3;
    public static final int URL_PATH_MIN_SIZE = 3;
    public static final int PARTNER_URL_MIN_SIZE = 3;
    public static final int NAME_MIN_SIZE = 3;
    public static final int PHONE_MIN_SIZE = 7;
    public static final int POSITION_MAX_SIZE = 80;
    public static final int POSITION_MIN_SIZE = 3;
    public static final int VALUE_MIN_SIZE = 4;
    public static final int PARTNER_CODE_MIN_SIZE = 3;
    public static final int URL_MIN_SIZE = 5;
    public static final int POINT_TYPE_MIN_SIZE = 1;
    public static final int CAMPAIGN_MIN_SIZE = 5;
    public static final int CAMPAIGN_MAX_SIZE = 10000;
    public static final int DESCRIPTION_MIN_SIZE = 10;
    public static final int DESCRIPTION_MAX_SIZE = 150;
    public static final int EXTENSION_MAX_SIZE = 5;
    public static final int EXTENSION_MIN_SIZE = 1;
    public static final int LINK_MAX_SIZE = 500;
    public static final int LINK_MIN_SIZE = 20;

    public static final int URL_PATH_MAX_SIZE = 50;
    public static final int PARTNER_URL_MAX_SIZE = 500;
    public static final int NAME_MAX_SIZE = 40;
    public static final int EMAIL_MAX_SIZE = 50;
    public static final int PHONE_MAX_SIZE = 20;
    public static final int VALUE_MAX_SIZE = 500;
    public static final int POSTAL_CODE_MAX_SIZE = 8;
    public static final int HASH_CODE_MAX_SIZE = 64;
    public static final int STRING_MAX_SIZE = 5;
    public static final int PARTNER_CODE_MAX_SIZE = 6;
    public static final int URL_MAX_SIZE = 500;
    public static final int POINT_TYPE_MAX_SIZE = 20;
    public static final int FIRST_NAME_MAX_SIZE = 13;
    public static final int SECTOR_CODE_MAX_SIZE = 20;
    public static final int SECTOR_CODE_MIN_SIZE = 1;
    public static final int CONTRACT_NUMBER_MAX_SIZE = 50;
    public static final int CONTRACT_NUMBER_MIN_SIZE = 1;
    public static final String X_PARTNER_CODE = "x-partner-code";
    public static final String X_CPF = "x-cpf";
    public static final String X_EMAIL = "x-email";

    public static final int FINAL_MINUTES = 59;
    public static final int FINAL_HOUR = 23;
    public static final int INITIAL_HOUR = 0;
    public static final int INITIAL_MINUTES = 0;

    public static final String SEND_FILEUPLOAD_TO_RABBIT_MQ_ERROR = "Send fileupload to RabbitMQ - Error: ";

    private ValidationConstraints() {
    }
}
