package kz.esb.enums;

public enum EsbError {

    /**
     * Internal system error.
     */
    SYSTEM_INTERNAL_ERROR("1000", "Internal system error.",
            EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Authentication Failure.
     */
    AUTHENTICATION_FAILURE("1002", "Authentication Failure.",
            EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Invalide Function.
     */
    INVALID_FUNCTION("1029", "invalid entry for Function.",
            EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Invalide CorrelationId.
     */
    CORRELATION_ID_INCORRECT("1033", "invalid entry for CorrelationId.",
            EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * CorrelationID is empty.
     */
    CORRELATION_ID_EMPTY("1035", "CorrelationID field must be populated.",
            EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Service is currently unavailable.
     */
    SERVICE_CURRENTLY_UNAVAILABLE("2003", "Service is currently unavailable.",
            EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Soap fault
     */
    SOAP_FAULT("2004", "SoapFault.",  EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Soap fault XSD invalid
     */
    SOAP_FAULT_XML_INVALID("2005", "Сообщение не прошло валидацию по схеме XSD.",  EsbErrorConsts.ERROR_TYPE_BUSINESS, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Soap fault Envelop version
     */
    SOAP_FAULT_ENVELOP_VERSION("2006", "Не удалось получить значение версии конверта.",  EsbErrorConsts.ERROR_TYPE_BUSINESS, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Soap fault Authentification failure
     */
    SOAP_FAULT_AUTHENTICATION_FAILURE("2007", "Отправитель не найден в системе.",  EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Soap fault Invalid class
     */
    SOAP_FAULT_INVALID_CLASS("2008", "Класс не найден в системе.",  EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Soap fault service currently unavailable
     */

    SOAP_FAULT_SERVICE_CURRENTLY_UNAVAILABLE("2009", "Ошибка отправки запроса.",  EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    /**
     * Service sync is currently unavailable.
     */
    SERVICE_SYNC_CURRENTLY_UNAVAILABLE("2010", "Класс заблокирован.",  EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SHEP_ASYNC_AUTHENTICATION_HEADERS_NOT_DEFINED("2011", "Не указаны параметры HTTP авторизации", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SHEP_ASYNC_AUTHENTICATION_HEADERS_NOT_VALID("2012", "Не верно указаны параметры HTTP авторизации", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SHEP_ASYNC_XML_INVALID("2013", "Ошибка разбора сообщения.", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SHEP_ASYNC_SIGN_ERROR("2014", "Ошибка подписи", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SHEP_ASYNC_SIGN_VALIDATE_ERROR("2015", "Ошибка валидации подписи", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SHEP_ASYNC_SERVICE_NOT_DEFINED("2016", "Не удалось определить класс сообщения ИШ на основе идентификатора сервиса ШЭП.", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SHEP_ASYNC_RESPONSE_ERROR("2017", "Получатель ответил ошибкой.", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SHEP_ASYNC_RESPONSE_EMPTY("2018", "Получен пустой ответ от ШЭП.", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SHEP_ASYNC_RESPONSE_CORRELATION_ID_EMPTY("2019", "Идентификатор корреляции не найден в системе", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    REQUEST_TIMEOUT_EXCEPTION("2020", "Превышен тайм-аут ожидания ответа..", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    SIGNATURE_VERIFICATION_FAILED("2021", "Проверка подписи не удалась", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    CERTIFICATE_EXPIRED("2022", "Срок действия сертификата истек", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),
    /**
     * Route error
     */

    REQUEST_FIRST_EXCEPTION("3000", "Ошибка при первой отправке", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL),

    REQUEST_SECOND_EXCEPTION("3001", "Ошибка при повторной отправке", EsbErrorConsts.RAISED_BY_GATEWAY, EsbErrorConsts.ERROR_TYPE_FATAL);

    private String code;
    private String description;
    private String raisedBy;
    private String type;

    /**
     * Code constructor.
     * @param code - error code.
     * @param description - error description.
     * @param raisedBy - raised by.
     * @param type - error type.
     */
    EsbError(String code, String description, String raisedBy, String type) {
        this.code = code;
        this.description = description;
        this.raisedBy = raisedBy;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getRaisedBy() {
        return raisedBy;
    }

    public String getType() {
        return type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRaisedBy(String raisedBy) {
        this.raisedBy = raisedBy;
    }

    public void setType(String type) {
        this.type = type;
    }
}
