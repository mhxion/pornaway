.class public Lorg/pornaway/util/HostsParser;
.super Ljava/lang/Object;
.source "HostsParser.java"


# instance fields
.field private mBlacklist:Lgnu/trove/set/hash/THashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lgnu/trove/set/hash/THashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mHostsParserMatcher:Ljava/util/regex/Matcher;

.field private mHostsParserPattern:Ljava/util/regex/Pattern;

.field private mParseRedirections:Z

.field private mParseWhitelist:Z

.field private mRedirectionList:Lgnu/trove/map/hash/THashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lgnu/trove/map/hash/THashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mWhitelist:Lgnu/trove/set/hash/THashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lgnu/trove/set/hash/THashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/io/BufferedReader;ZZ)V
    .registers 4
    .param p1, "input"    # Ljava/io/BufferedReader;
    .param p2, "parseWhitelist"    # Z
    .param p3, "parseRedirections"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-boolean p2, p0, Lorg/pornaway/util/HostsParser;->mParseWhitelist:Z

    .line 52
    iput-boolean p3, p0, Lorg/pornaway/util/HostsParser;->mParseRedirections:Z

    .line 53
    invoke-direct {p0, p1}, Lorg/pornaway/util/HostsParser;->parse(Ljava/io/BufferedReader;)V

    .line 54
    return-void
.end method

.method private parse(Ljava/io/BufferedReader;)V
    .registers 8
    .param p1, "reader"    # Ljava/io/BufferedReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 78
    new-instance v3, Lgnu/trove/set/hash/THashSet;

    invoke-direct {v3}, Lgnu/trove/set/hash/THashSet;-><init>()V

    iput-object v3, p0, Lorg/pornaway/util/HostsParser;->mBlacklist:Lgnu/trove/set/hash/THashSet;

    .line 79
    new-instance v3, Lgnu/trove/set/hash/THashSet;

    invoke-direct {v3}, Lgnu/trove/set/hash/THashSet;-><init>()V

    iput-object v3, p0, Lorg/pornaway/util/HostsParser;->mWhitelist:Lgnu/trove/set/hash/THashSet;

    .line 80
    new-instance v3, Lgnu/trove/map/hash/THashMap;

    invoke-direct {v3}, Lgnu/trove/map/hash/THashMap;-><init>()V

    iput-object v3, p0, Lorg/pornaway/util/HostsParser;->mRedirectionList:Lgnu/trove/map/hash/THashMap;

    .line 83
    iget-boolean v3, p0, Lorg/pornaway/util/HostsParser;->mParseWhitelist:Z

    if-eqz v3, :cond_5f

    .line 84
    sget-object v3, Lorg/pornaway/util/RegexUtils;->hostsParserWhitelistImportPattern:Ljava/util/regex/Pattern;

    iput-object v3, p0, Lorg/pornaway/util/HostsParser;->mHostsParserPattern:Ljava/util/regex/Pattern;

    .line 88
    :cond_1d
    :goto_1d
    invoke-virtual {p1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    .local v2, "nextLine":Ljava/lang/String;
    if-eqz v2, :cond_95

    .line 89
    iget-object v3, p0, Lorg/pornaway/util/HostsParser;->mHostsParserPattern:Ljava/util/regex/Pattern;

    invoke-virtual {v3, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v3

    iput-object v3, p0, Lorg/pornaway/util/HostsParser;->mHostsParserMatcher:Ljava/util/regex/Matcher;

    .line 91
    iget-object v3, p0, Lorg/pornaway/util/HostsParser;->mHostsParserMatcher:Ljava/util/regex/Matcher;

    invoke-virtual {v3}, Ljava/util/regex/Matcher;->matches()Z

    move-result v3

    if-eqz v3, :cond_7c

    .line 96
    iget-object v3, p0, Lorg/pornaway/util/HostsParser;->mHostsParserMatcher:Ljava/util/regex/Matcher;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v1

    .line 97
    .local v1, "currentIp":Ljava/lang/String;
    iget-object v3, p0, Lorg/pornaway/util/HostsParser;->mHostsParserMatcher:Ljava/util/regex/Matcher;

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    .line 100
    .local v0, "currentHostname":Ljava/lang/String;
    const-string v3, "127.0.0.1"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_59

    const-string v3, "0.0.0.0"

    .line 101
    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_59

    const-string v3, "::1"

    .line 102
    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_64

    .line 103
    :cond_59
    iget-object v3, p0, Lorg/pornaway/util/HostsParser;->mBlacklist:Lgnu/trove/set/hash/THashSet;

    invoke-virtual {v3, v0}, Lgnu/trove/set/hash/THashSet;->add(Ljava/lang/Object;)Z

    goto :goto_1d

    .line 86
    .end local v0    # "currentHostname":Ljava/lang/String;
    .end local v1    # "currentIp":Ljava/lang/String;
    .end local v2    # "nextLine":Ljava/lang/String;
    :cond_5f
    sget-object v3, Lorg/pornaway/util/RegexUtils;->hostsParserPattern:Ljava/util/regex/Pattern;

    iput-object v3, p0, Lorg/pornaway/util/HostsParser;->mHostsParserPattern:Ljava/util/regex/Pattern;

    goto :goto_1d

    .line 104
    .restart local v0    # "currentHostname":Ljava/lang/String;
    .restart local v1    # "currentIp":Ljava/lang/String;
    .restart local v2    # "nextLine":Ljava/lang/String;
    :cond_64
    const-string v3, "white"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_72

    .line 105
    iget-object v3, p0, Lorg/pornaway/util/HostsParser;->mWhitelist:Lgnu/trove/set/hash/THashSet;

    invoke-virtual {v3, v0}, Lgnu/trove/set/hash/THashSet;->add(Ljava/lang/Object;)Z

    goto :goto_1d

    .line 106
    :cond_72
    iget-boolean v3, p0, Lorg/pornaway/util/HostsParser;->mParseRedirections:Z

    if-eqz v3, :cond_1d

    .line 107
    iget-object v3, p0, Lorg/pornaway/util/HostsParser;->mRedirectionList:Lgnu/trove/map/hash/THashMap;

    invoke-virtual {v3, v0, v1}, Lgnu/trove/map/hash/THashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1d

    .line 110
    .end local v0    # "currentHostname":Ljava/lang/String;
    .end local v1    # "currentIp":Ljava/lang/String;
    :cond_7c
    const-string v3, "PornAway"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Does not match: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1d

    .line 115
    :cond_95
    iget-object v3, p0, Lorg/pornaway/util/HostsParser;->mBlacklist:Lgnu/trove/set/hash/THashSet;

    const-string v4, "localhost"

    invoke-virtual {v3, v4}, Lgnu/trove/set/hash/THashSet;->remove(Ljava/lang/Object;)Z

    .line 116
    iget-object v3, p0, Lorg/pornaway/util/HostsParser;->mRedirectionList:Lgnu/trove/map/hash/THashMap;

    const-string v4, "localhost"

    invoke-virtual {v3, v4}, Lgnu/trove/map/hash/THashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 117
    return-void
.end method


# virtual methods
.method public addBlacklist(Lgnu/trove/set/hash/THashSet;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lgnu/trove/set/hash/THashSet",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 125
    .local p1, "blacklist":Lgnu/trove/set/hash/THashSet;, "Lgnu/trove/set/hash/THashSet<Ljava/lang/String;>;"
    iget-object v0, p0, Lorg/pornaway/util/HostsParser;->mBlacklist:Lgnu/trove/set/hash/THashSet;

    invoke-virtual {v0, p1}, Lgnu/trove/set/hash/THashSet;->addAll(Ljava/util/Collection;)Z

    .line 126
    return-void
.end method

.method public addRedirectionList(Lgnu/trove/map/hash/THashMap;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lgnu/trove/map/hash/THashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 146
    .local p1, "redirectionList":Lgnu/trove/map/hash/THashMap;, "Lgnu/trove/map/hash/THashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lorg/pornaway/util/HostsParser;->mRedirectionList:Lgnu/trove/map/hash/THashMap;

    invoke-virtual {v0, p1}, Lgnu/trove/map/hash/THashMap;->putAll(Ljava/util/Map;)V

    .line 147
    return-void
.end method

.method public addWhitelist(Lgnu/trove/set/hash/THashSet;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lgnu/trove/set/hash/THashSet",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 134
    .local p1, "whitelist":Lgnu/trove/set/hash/THashSet;, "Lgnu/trove/set/hash/THashSet<Ljava/lang/String;>;"
    iget-object v0, p0, Lorg/pornaway/util/HostsParser;->mWhitelist:Lgnu/trove/set/hash/THashSet;

    invoke-virtual {v0, p1}, Lgnu/trove/set/hash/THashSet;->addAll(Ljava/util/Collection;)Z

    .line 135
    return-void
.end method

.method public compileList()V
    .registers 13

    .prologue
    .line 153
    const-string v9, "PornAway"

    const-string v10, "Compiling all whitelist regex"

    invoke-static {v9, v10}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    new-instance v8, Lgnu/trove/set/hash/THashSet;

    invoke-direct {v8}, Lgnu/trove/set/hash/THashSet;-><init>()V

    .line 158
    .local v8, "whitelistPattern":Lgnu/trove/set/hash/THashSet;, "Lgnu/trove/set/hash/THashSet<Ljava/util/regex/Pattern;>;"
    iget-object v9, p0, Lorg/pornaway/util/HostsParser;->mWhitelist:Lgnu/trove/set/hash/THashSet;

    invoke-virtual {v9}, Lgnu/trove/set/hash/THashSet;->iterator()Lgnu/trove/iterator/hash/TObjectHashIterator;

    move-result-object v9

    :goto_12
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_2a

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 160
    .local v2, "item":Ljava/lang/String;
    invoke-static {v2}, Lorg/pornaway/util/RegexUtils;->wildcardToRegex(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 161
    .local v6, "regexItem":Ljava/lang/String;
    invoke-static {v6}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v10

    invoke-virtual {v8, v10}, Lgnu/trove/set/hash/THashSet;->add(Ljava/lang/Object;)Z

    goto :goto_12

    .line 164
    .end local v2    # "item":Ljava/lang/String;
    .end local v6    # "regexItem":Ljava/lang/String;
    :cond_2a
    invoke-virtual {v8}, Lgnu/trove/set/hash/THashSet;->size()I

    move-result v9

    if-lez v9, :cond_88

    .line 165
    const-string v9, "PornAway"

    const-string v10, "Starting whitelist regex"

    invoke-static {v9, v10}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 169
    iget-object v9, p0, Lorg/pornaway/util/HostsParser;->mBlacklist:Lgnu/trove/set/hash/THashSet;

    invoke-virtual {v9}, Lgnu/trove/set/hash/THashSet;->iterator()Lgnu/trove/iterator/hash/TObjectHashIterator;

    move-result-object v3

    .local v3, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_3d
    :goto_3d
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_70

    .line 170
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 173
    .local v0, "blacklistHostname":Ljava/lang/String;
    invoke-virtual {v8}, Lgnu/trove/set/hash/THashSet;->iterator()Lgnu/trove/iterator/hash/TObjectHashIterator;

    move-result-object v9

    :cond_4d
    :goto_4d
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_3d

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/regex/Pattern;

    .line 174
    .local v4, "pattern":Ljava/util/regex/Pattern;
    invoke-virtual {v4, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    .line 177
    .local v7, "whitelistMatcher":Ljava/util/regex/Matcher;
    :try_start_5d
    invoke-virtual {v7}, Ljava/util/regex/Matcher;->find()Z

    move-result v10

    if-eqz v10, :cond_4d

    .line 179
    invoke-interface {v3}, Ljava/util/Iterator;->remove()V
    :try_end_66
    .catch Ljava/lang/Exception; {:try_start_5d .. :try_end_66} :catch_67

    goto :goto_3d

    .line 182
    :catch_67
    move-exception v1

    .line 185
    .local v1, "e":Ljava/lang/Exception;
    const-string v10, "PornAway"

    const-string v11, "Error in whitelist regex processing"

    invoke-static {v10, v11, v1}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_4d

    .line 189
    .end local v0    # "blacklistHostname":Ljava/lang/String;
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v4    # "pattern":Ljava/util/regex/Pattern;
    .end local v7    # "whitelistMatcher":Ljava/util/regex/Matcher;
    :cond_70
    const-string v9, "PornAway"

    const-string v10, "Ending whitelist regex"

    invoke-static {v9, v10}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 195
    .end local v3    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_77
    new-instance v5, Lgnu/trove/set/hash/THashSet;

    iget-object v9, p0, Lorg/pornaway/util/HostsParser;->mRedirectionList:Lgnu/trove/map/hash/THashMap;

    invoke-virtual {v9}, Lgnu/trove/map/hash/THashMap;->keySet()Ljava/util/Set;

    move-result-object v9

    invoke-direct {v5, v9}, Lgnu/trove/set/hash/THashSet;-><init>(Ljava/util/Collection;)V

    .line 196
    .local v5, "redirectionRemove":Lgnu/trove/set/hash/THashSet;, "Lgnu/trove/set/hash/THashSet<Ljava/lang/String;>;"
    iget-object v9, p0, Lorg/pornaway/util/HostsParser;->mBlacklist:Lgnu/trove/set/hash/THashSet;

    invoke-virtual {v9, v5}, Lgnu/trove/set/hash/THashSet;->removeAll(Ljava/util/Collection;)Z

    .line 197
    return-void

    .line 191
    .end local v5    # "redirectionRemove":Lgnu/trove/set/hash/THashSet;, "Lgnu/trove/set/hash/THashSet<Ljava/lang/String;>;"
    :cond_88
    const-string v9, "PornAway"

    const-string v10, "Skipping whitelist regex"

    invoke-static {v9, v10}, Lorg/pornaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_77
.end method

.method public getBlacklist()Lgnu/trove/set/hash/THashSet;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lgnu/trove/set/hash/THashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lorg/pornaway/util/HostsParser;->mBlacklist:Lgnu/trove/set/hash/THashSet;

    return-object v0
.end method

.method public getRedirectionList()Lgnu/trove/map/hash/THashMap;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lgnu/trove/map/hash/THashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 65
    iget-object v0, p0, Lorg/pornaway/util/HostsParser;->mRedirectionList:Lgnu/trove/map/hash/THashMap;

    return-object v0
.end method

.method public getWhitelist()Lgnu/trove/set/hash/THashSet;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lgnu/trove/set/hash/THashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    iget-object v0, p0, Lorg/pornaway/util/HostsParser;->mWhitelist:Lgnu/trove/set/hash/THashSet;

    return-object v0
.end method
