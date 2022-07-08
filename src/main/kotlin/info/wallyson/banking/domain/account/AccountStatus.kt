package info.wallyson.banking.domain.account

enum class AccountStatus {
    ACTIVE,
    CLOSED_BY_CLIENT,
    BLOCKED_BY_LEGAL_ORDER,
    BLOCKED_DUE_SECURITY_RISK;
}
