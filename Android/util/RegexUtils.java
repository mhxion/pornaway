.class public Lorg/pornaway/util/RegexUtils;
.super Ljava/lang/Object;
.source "RegexUtils.java"


# static fields
.field private static final HOSTNAME_REGEX:Ljava/lang/String; = "[a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-\\_\\.]{0,61}[a-zA-Z0-9]"

.field private static final HOSTS_PARSER:Ljava/lang/String; = "^\\s*((?:(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(?:\\.(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3})|(?:[0-9A-F\\:\\.]+))\\s+([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-\\_\\.]{0,61}[a-zA-Z0-9])\\s*(?:\\#.*)*\\s*$"

.field private static final HOSTS_PARSER_WHITELIST_IMPORT:Ljava/lang/String; = "^\\s*((?:(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(?:\\.(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3})|(?:[0-9A-F\\:\\.]+)|(?:white))\\s+([a-zA-Z0-9\\*\\?]|[a-zA-Z0-9\\*\\?][a-zA-Z0-9\\-\\_\\.\\*\\?]{0,61}[a-zA-Z0-9\\*\\?])\\s*(?:\\#.*)*\\s*$"

.field private static final IPV4_REGEX:Ljava/lang/String; = "(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(?:\\.(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}"

.field private static final IPV6_REGEX:Ljava/lang/String; = "(((?=(?>.*?::)(?!.*::)))(::)?([0-9A-F]{1,4}::?){0,5}|([0-9A-F]{1,4}:){6})(\u0002([0-9A-F]{1,4}(::?|$)){0,2}|((25[0-5]|(2[0-4]|1\\d|[1-9])?\\d)(\\.|$)){4}|[0-9A-F]{1,4}:[0-9A-F]{1,4})(?<![^:]:|\\.)"

.field private static final SIMPLE_IPV6_REGEX:Ljava/lang/String; = "[0-9A-F\\:\\.]+"

.field private static final TCPDUMP_HOSTNAME_REGEX:Ljava/lang/String; = "(A\\?|AAAA\\?)\\s(\\S+)\\.\\s"

.field private static final WHITELIST_HOSTNAME_REGEX:Ljava/lang/String; = "[a-zA-Z0-9\\*\\?]|[a-zA-Z0-9\\*\\?][a-zA-Z0-9\\-\\_\\.\\*\\?]{0,61}[a-zA-Z0-9\\*\\?]"

.field public static hostsParserPattern:Ljava/util/regex/Pattern;

.field public static hostsParserWhitelistImportPattern:Ljava/util/regex/Pattern;

.field private static mHostnameMatcher:Ljava/util/regex/Matcher;

.field private static mHostnamePattern:Ljava/util/regex/Pattern;

.field private static mIPv4Matcher:Ljava/util/regex/Matcher;

.field private static mIPv4Pattern:Ljava/util/regex/Pattern;

.field private static mIPv6Matcher:Ljava/util/regex/Matcher;

.field private static mIPv6Pattern:Ljava/util/regex/Pattern;

.field private static mTcpdumpHostnameMatcher:Ljava/util/regex/Matcher;

.field private static mTcpdumpHostnamePattern:Ljava/util/regex/Pattern;

.field private static mWhitelistHostnameMatcher:Ljava/util/regex/Matcher;

.field private static mWhitelistHostnamePattern:Ljava/util/regex/Pattern;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    const/4 v1, 0x2

    .line 81
    const-string v0, "[a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-\\_\\.]{0,61}[a-zA-Z0-9]"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/pornaway/util/RegexUtils;->mHostnamePattern:Ljava/util/regex/Pattern;

    .line 82
    const-string v0, "[a-zA-Z0-9\\*\\?]|[a-zA-Z0-9\\*\\?][a-zA-Z0-9\\-\\_\\.\\*\\?]{0,61}[a-zA-Z0-9\\*\\?]"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/pornaway/util/RegexUtils;->mWhitelistHostnamePattern:Ljava/util/regex/Pattern;

    .line 83
    const-string v0, "(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(?:\\.(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/pornaway/util/RegexUtils;->mIPv4Pattern:Ljava/util/regex/Pattern;

    .line 84
    const-string v0, "(((?=(?>.*?::)(?!.*::)))(::)?([0-9A-F]{1,4}::?){0,5}|([0-9A-F]{1,4}:){6})(\u0002([0-9A-F]{1,4}(::?|$)){0,2}|((25[0-5]|(2[0-4]|1\\d|[1-9])?\\d)(\\.|$)){4}|[0-9A-F]{1,4}:[0-9A-F]{1,4})(?<![^:]:|\\.)"

    invoke-static {v0, v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/pornaway/util/RegexUtils;->mIPv6Pattern:Ljava/util/regex/Pattern;

    .line 85
    const-string v0, "(A\\?|AAAA\\?)\\s(\\S+)\\.\\s"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/pornaway/util/RegexUtils;->mTcpdumpHostnamePattern:Ljava/util/regex/Pattern;

    .line 86
    const-string v0, "^\\s*((?:(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(?:\\.(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3})|(?:[0-9A-F\\:\\.]+))\\s+([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-\\_\\.]{0,61}[a-zA-Z0-9])\\s*(?:\\#.*)*\\s*$"

    invoke-static {v0, v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/pornaway/util/RegexUtils;->hostsParserPattern:Ljava/util/regex/Pattern;

    .line 87
    const-string v0, "^\\s*((?:(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(?:\\.(?:25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3})|(?:[0-9A-F\\:\\.]+)|(?:white))\\s+([a-zA-Z0-9\\*\\?]|[a-zA-Z0-9\\*\\?][a-zA-Z0-9\\-\\_\\.\\*\\?]{0,61}[a-zA-Z0-9\\*\\?])\\s*(?:\\#.*)*\\s*$"

    invoke-static {v0, v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/pornaway/util/RegexUtils;->hostsParserWhitelistImportPattern:Ljava/util/regex/Pattern;

    .line 89
    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getTcpdumpHostname(Ljava/lang/String;)Ljava/lang/String;
    .registers 6
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 186
    sget-object v2, Lorg/pornaway/util/RegexUtils;->mTcpdumpHostnamePattern:Ljava/util/regex/Pattern;

    invoke-virtual {v2, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    sput-object v2, Lorg/pornaway/util/RegexUtils;->mTcpdumpHostnameMatcher:Ljava/util/regex/Matcher;

    .line 189
    :try_start_9
    sget-object v2, Lorg/pornaway/util/RegexUtils;->mTcpdumpHostnameMatcher:Ljava/util/regex/Matcher;

    invoke-virtual {v2}, Ljava/util/regex/Matcher;->find()Z

    move-result v2

    if-eqz v2, :cond_19

    .line 190
    sget-object v2, Lorg/pornaway/util/RegexUtils;->mTcpdumpHostnameMatcher:Ljava/util/regex/Matcher;

    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v1

    .line 198
    :goto_18
    return-object v1

    .line 192
    :cond_19
    const-string v2, "PornAway"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Does not find: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_31
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_31} :catch_32

    goto :goto_18

    .line 195
    :catch_32
    move-exception v0

    .line 196
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "PornAway"

    const-string v3, "Error in getTcpdumpHostname"

    invoke-static {v2, v3, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_18
.end method

.method public static isValidHostname(Ljava/lang/String;)Z
    .registers 4
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    .line 109
    sget-object v1, Lorg/pornaway/util/RegexUtils;->mHostnamePattern:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    sput-object v1, Lorg/pornaway/util/RegexUtils;->mHostnameMatcher:Ljava/util/regex/Matcher;

    .line 112
    :try_start_8
    sget-object v1, Lorg/pornaway/util/RegexUtils;->mHostnameMatcher:Ljava/util/regex/Matcher;

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_d} :catch_f

    move-result v1

    .line 116
    :goto_e
    return v1

    .line 113
    :catch_f
    move-exception v0

    .line 114
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "PornAway"

    const-string v2, "Error in isValidHostname"

    invoke-static {v1, v2, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 116
    const/4 v1, 0x1

    goto :goto_e
.end method

.method public static isValidIP(Ljava/lang/String;)Z
    .registers 4
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    .line 172
    const-string v0, "PornAway"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "input: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    const-string v0, "PornAway"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "isvalidipv4: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p0}, Lorg/pornaway/util/RegexUtils;->isValidIPv4(Ljava/lang/String;)Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    const-string v0, "PornAway"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "isvalidipv6: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p0}, Lorg/pornaway/util/RegexUtils;->isValidIPv6(Ljava/lang/String;)Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    invoke-static {p0}, Lorg/pornaway/util/RegexUtils;->isValidIPv4(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5c

    invoke-static {p0}, Lorg/pornaway/util/RegexUtils;->isValidIPv6(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5e

    :cond_5c
    const/4 v0, 0x1

    :goto_5d
    return v0

    :cond_5e
    const/4 v0, 0x0

    goto :goto_5d
.end method

.method public static isValidIPv4(Ljava/lang/String;)Z
    .registers 4
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    .line 142
    sget-object v1, Lorg/pornaway/util/RegexUtils;->mIPv4Pattern:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    sput-object v1, Lorg/pornaway/util/RegexUtils;->mIPv4Matcher:Ljava/util/regex/Matcher;

    .line 145
    :try_start_8
    sget-object v1, Lorg/pornaway/util/RegexUtils;->mIPv4Matcher:Ljava/util/regex/Matcher;

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_d} :catch_f

    move-result v1

    .line 149
    :goto_e
    return v1

    .line 146
    :catch_f
    move-exception v0

    .line 147
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "PornAway"

    const-string v2, "Error in isValidIPv4"

    invoke-static {v1, v2, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 149
    const/4 v1, 0x1

    goto :goto_e
.end method

.method public static isValidIPv6(Ljava/lang/String;)Z
    .registers 4
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    .line 157
    sget-object v1, Lorg/pornaway/util/RegexUtils;->mIPv6Pattern:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    sput-object v1, Lorg/pornaway/util/RegexUtils;->mIPv6Matcher:Ljava/util/regex/Matcher;

    .line 160
    :try_start_8
    sget-object v1, Lorg/pornaway/util/RegexUtils;->mIPv6Matcher:Ljava/util/regex/Matcher;

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_d} :catch_f

    move-result v1

    .line 164
    :goto_e
    return v1

    .line 161
    :catch_f
    move-exception v0

    .line 162
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "PornAway"

    const-string v2, "Error in isValidIPv6"

    invoke-static {v1, v2, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 164
    const/4 v1, 0x1

    goto :goto_e
.end method

.method public static isValidUrl(Ljava/lang/String;)Z
    .registers 2
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    .line 98
    invoke-static {p0}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isValidWhitelistHostname(Ljava/lang/String;)Z
    .registers 4
    .param p0, "input"    # Ljava/lang/String;

    .prologue
    .line 127
    sget-object v1, Lorg/pornaway/util/RegexUtils;->mWhitelistHostnamePattern:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    sput-object v1, Lorg/pornaway/util/RegexUtils;->mWhitelistHostnameMatcher:Ljava/util/regex/Matcher;

    .line 130
    :try_start_8
    sget-object v1, Lorg/pornaway/util/RegexUtils;->mWhitelistHostnameMatcher:Ljava/util/regex/Matcher;

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_d} :catch_f

    move-result v1

    .line 134
    :goto_e
    return v1

    .line 131
    :catch_f
    move-exception v0

    .line 132
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "PornAway"

    const-string v2, "Error in isValidHostname"

    invoke-static {v1, v2, v0}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 134
    const/4 v1, 0x1

    goto :goto_e
.end method

.method public static wildcardToRegex(Ljava/lang/String;)Ljava/lang/String;
    .registers 6
    .param p0, "wildcard"    # Ljava/lang/String;

    .prologue
    .line 207
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 208
    .local v3, "s":Ljava/lang/StringBuffer;
    const/16 v4, 0x5e

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 209
    const/4 v1, 0x0

    .local v1, "i":I
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .local v2, "is":I
    :goto_13
    if-ge v1, v2, :cond_37

    .line 210
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 211
    .local v0, "c":C
    sparse-switch v0, :sswitch_data_42

    .line 234
    invoke-virtual {v3, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 209
    :goto_1f
    add-int/lit8 v1, v1, 0x1

    goto :goto_13

    .line 213
    :sswitch_22
    const-string v4, ".*"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1f

    .line 216
    :sswitch_28
    const-string v4, "."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1f

    .line 230
    :sswitch_2e
    const-string v4, "\\"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 231
    invoke-virtual {v3, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_1f

    .line 238
    .end local v0    # "c":C
    :cond_37
    const/16 v4, 0x24

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 239
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 211
    nop

    :sswitch_data_42
    .sparse-switch
        0x24 -> :sswitch_2e
        0x28 -> :sswitch_2e
        0x29 -> :sswitch_2e
        0x2a -> :sswitch_22
        0x2e -> :sswitch_2e
        0x3f -> :sswitch_28
        0x5b -> :sswitch_2e
        0x5c -> :sswitch_2e
        0x5d -> :sswitch_2e
        0x5e -> :sswitch_2e
        0x7b -> :sswitch_2e
        0x7c -> :sswitch_2e
        0x7d -> :sswitch_2e
    .end sparse-switch
.end method
