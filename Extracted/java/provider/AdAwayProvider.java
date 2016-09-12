.class public Lorg/adaway/provider/AdAwayProvider;
.super Landroid/content/ContentProvider;
.source "AdAwayProvider.java"


# static fields
.field private static final BLACKLIST:I = 0x12c

.field private static final BLACKLIST_ID:I = 0x12d

.field private static final HOSTS_SOURCES:I = 0x64

.field private static final HOSTS_SOURCES_ID:I = 0x65

.field private static final REDIRECTION_LIST:I = 0x190

.field private static final REDIRECTION_LIST_ID:I = 0x191

.field private static final WHITELIST:I = 0xc8

.field private static final WHITELIST_ID:I = 0xc9

.field private static final sUriMatcher:Landroid/content/UriMatcher;


# instance fields
.field private mAdAwayDatabase:Lorg/adaway/provider/AdAwayDatabase;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 46
    invoke-static {}, Lorg/adaway/provider/AdAwayProvider;->buildUriMatcher()Landroid/content/UriMatcher;

    move-result-object v0

    sput-object v0, Lorg/adaway/provider/AdAwayProvider;->sUriMatcher:Landroid/content/UriMatcher;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 45
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method

.method private buildDefaultSelection(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;

    .prologue
    .line 294
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x1

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 295
    .local v0, "rowId":Ljava/lang/String;
    const-string v1, ""

    .line 296
    .local v1, "where":Ljava/lang/String;
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2c

    .line 297
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, " AND ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 300
    :cond_2c
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "_id="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private static buildUriMatcher()Landroid/content/UriMatcher;
    .registers 5

    .prologue
    .line 65
    new-instance v1, Landroid/content/UriMatcher;

    const/4 v2, -0x1

    invoke-direct {v1, v2}, Landroid/content/UriMatcher;-><init>(I)V

    .line 66
    .local v1, "matcher":Landroid/content/UriMatcher;
    const-string v0, "org.adaway"

    .line 69
    .local v0, "authority":Ljava/lang/String;
    const-string v2, "org.adaway"

    const-string v3, "hostssources"

    const/16 v4, 0x64

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 70
    const-string v2, "org.adaway"

    const-string v3, "hostssources/#"

    const/16 v4, 0x65

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 73
    const-string v2, "org.adaway"

    const-string v3, "whitelist"

    const/16 v4, 0xc8

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 74
    const-string v2, "org.adaway"

    const-string v3, "whitelist/#"

    const/16 v4, 0xc9

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 77
    const-string v2, "org.adaway"

    const-string v3, "blacklist"

    const/16 v4, 0x12c

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 78
    const-string v2, "org.adaway"

    const-string v3, "blacklist/#"

    const/16 v4, 0x12d

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 81
    const-string v2, "org.adaway"

    const-string v3, "redirectionlist"

    const/16 v4, 0x190

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 82
    const-string v2, "org.adaway"

    const-string v3, "redirectionlist/#"

    const/16 v4, 0x191

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 84
    return-object v1
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .registers 10
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 252
    const-string v3, "AdAway"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "delete(uri="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lorg/adaway/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 254
    iget-object v3, p0, Lorg/adaway/provider/AdAwayProvider;->mAdAwayDatabase:Lorg/adaway/provider/AdAwayDatabase;

    invoke-virtual {v3}, Lorg/adaway/provider/AdAwayDatabase;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 257
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-object v3, Lorg/adaway/provider/AdAwayProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v3, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    .line 258
    .local v2, "match":I
    sparse-switch v2, :sswitch_data_7e

    .line 276
    new-instance v3, Ljava/lang/UnsupportedOperationException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unknown uri: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 260
    :sswitch_46
    const-string v3, "hosts_sources"

    invoke-direct {p0, p1, p2}, Lorg/adaway/provider/AdAwayProvider;->buildDefaultSelection(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 280
    .local v0, "count":I
    :goto_50
    invoke-virtual {p0}, Lorg/adaway/provider/AdAwayProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, p1, v4}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 282
    return v0

    .line 264
    .end local v0    # "count":I
    :sswitch_5d
    const-string v3, "whitelist"

    invoke-direct {p0, p1, p2}, Lorg/adaway/provider/AdAwayProvider;->buildDefaultSelection(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 266
    .restart local v0    # "count":I
    goto :goto_50

    .line 268
    .end local v0    # "count":I
    :sswitch_68
    const-string v3, "blacklist"

    invoke-direct {p0, p1, p2}, Lorg/adaway/provider/AdAwayProvider;->buildDefaultSelection(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 270
    .restart local v0    # "count":I
    goto :goto_50

    .line 272
    .end local v0    # "count":I
    :sswitch_73
    const-string v3, "redirection_list"

    invoke-direct {p0, p1, p2}, Lorg/adaway/provider/AdAwayProvider;->buildDefaultSelection(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 274
    .restart local v0    # "count":I
    goto :goto_50

    .line 258
    :sswitch_data_7e
    .sparse-switch
        0x65 -> :sswitch_46
        0xc9 -> :sswitch_5d
        0x12d -> :sswitch_68
        0x191 -> :sswitch_73
    .end sparse-switch
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .registers 6
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 104
    sget-object v1, Lorg/adaway/provider/AdAwayProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v0

    .line 105
    .local v0, "match":I
    sparse-switch v0, :sswitch_data_3a

    .line 123
    new-instance v1, Ljava/lang/UnsupportedOperationException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown uri: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 107
    :sswitch_22
    const-string v1, "vnd.android.cursor.dir/vnd.adaway.hostssources"

    .line 121
    :goto_24
    return-object v1

    .line 109
    :sswitch_25
    const-string v1, "vnd.android.cursor.item/vnd.adaway.hostssources"

    goto :goto_24

    .line 111
    :sswitch_28
    const-string v1, "vnd.android.cursor.dir/vnd.adaway.whitelist"

    goto :goto_24

    .line 113
    :sswitch_2b
    const-string v1, "vnd.android.cursor.item/vnd.adaway.whitelist"

    goto :goto_24

    .line 115
    :sswitch_2e
    const-string v1, "vnd.android.cursor.dir/vnd.adaway.blacklist"

    goto :goto_24

    .line 117
    :sswitch_31
    const-string v1, "vnd.android.cursor.item/vnd.adaway.blacklist"

    goto :goto_24

    .line 119
    :sswitch_34
    const-string v1, "vnd.android.cursor.dir/vnd.adaway.redirectionlist"

    goto :goto_24

    .line 121
    :sswitch_37
    const-string v1, "vnd.android.cursor.item/vnd.adaway.redirectionlist"

    goto :goto_24

    .line 105
    :sswitch_data_3a
    .sparse-switch
        0x64 -> :sswitch_22
        0x65 -> :sswitch_25
        0xc8 -> :sswitch_28
        0xc9 -> :sswitch_2b
        0x12c -> :sswitch_2e
        0x12d -> :sswitch_31
        0x190 -> :sswitch_34
        0x191 -> :sswitch_37
    .end sparse-switch
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .registers 13
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v9, 0x0

    .line 132
    const-string v6, "AdAway"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "insert(uri="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", values="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p2}, Landroid/content/ContentValues;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lorg/adaway/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    iget-object v6, p0, Lorg/adaway/provider/AdAwayProvider;->mAdAwayDatabase:Lorg/adaway/provider/AdAwayDatabase;

    invoke-virtual {v6}, Lorg/adaway/provider/AdAwayDatabase;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 136
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v3, 0x0

    .line 137
    .local v3, "rowUri":Landroid/net/Uri;
    const-wide/16 v4, -0x1

    .line 139
    .local v4, "rowId":J
    :try_start_36
    sget-object v6, Lorg/adaway/provider/AdAwayProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v6, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    .line 140
    .local v2, "match":I
    sparse-switch v2, :sswitch_data_ac

    .line 158
    new-instance v6, Ljava/lang/UnsupportedOperationException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unknown uri: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v6
    :try_end_58
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_36 .. :try_end_58} :catch_58

    .line 160
    .end local v2    # "match":I
    :catch_58
    move-exception v1

    .line 161
    .local v1, "e":Landroid/database/sqlite/SQLiteConstraintException;
    const-string v6, "AdAway"

    const-string v7, "Constraint exception on insert! Entry already existing?"

    invoke-static {v6, v7}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    .end local v1    # "e":Landroid/database/sqlite/SQLiteConstraintException;
    :goto_60
    invoke-virtual {p0}, Lorg/adaway/provider/AdAwayProvider;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    invoke-virtual {v6, p1, v9}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 167
    return-object v3

    .line 142
    .restart local v2    # "match":I
    :sswitch_6c
    :try_start_6c
    const-string v6, "hosts_sources"

    const/4 v7, 0x0

    invoke-virtual {v0, v6, v7, p2}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    .line 143
    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lorg/adaway/provider/AdAwayContract$HostsSources;->buildUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 144
    goto :goto_60

    .line 146
    :sswitch_7c
    const-string v6, "whitelist"

    const/4 v7, 0x0

    invoke-virtual {v0, v6, v7, p2}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    .line 147
    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lorg/adaway/provider/AdAwayContract$Whitelist;->buildUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 148
    goto :goto_60

    .line 150
    :sswitch_8c
    const-string v6, "blacklist"

    const/4 v7, 0x0

    invoke-virtual {v0, v6, v7, p2}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    .line 151
    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lorg/adaway/provider/AdAwayContract$Blacklist;->buildUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 152
    goto :goto_60

    .line 154
    :sswitch_9c
    const-string v6, "redirection_list"

    const/4 v7, 0x0

    invoke-virtual {v0, v6, v7, p2}, Landroid/database/sqlite/SQLiteDatabase;->insertOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    .line 155
    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lorg/adaway/provider/AdAwayContract$RedirectionList;->buildUri(Ljava/lang/String;)Landroid/net/Uri;
    :try_end_aa
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_6c .. :try_end_aa} :catch_58

    move-result-object v3

    .line 156
    goto :goto_60

    .line 140
    :sswitch_data_ac
    .sparse-switch
        0x64 -> :sswitch_6c
        0xc8 -> :sswitch_7c
        0x12c -> :sswitch_8c
        0x190 -> :sswitch_9c
    .end sparse-switch
.end method

.method public onCreate()Z
    .registers 3

    .prologue
    .line 94
    invoke-virtual {p0}, Lorg/adaway/provider/AdAwayProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 95
    .local v0, "context":Landroid/content/Context;
    new-instance v1, Lorg/adaway/provider/AdAwayDatabase;

    invoke-direct {v1, v0}, Lorg/adaway/provider/AdAwayDatabase;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lorg/adaway/provider/AdAwayProvider;->mAdAwayDatabase:Lorg/adaway/provider/AdAwayDatabase;

    .line 96
    const/4 v1, 0x1

    return v1
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .registers 16
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 176
    const-string v2, "AdAway"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "query(uri="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", proj="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {p2}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lorg/adaway/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 178
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 179
    .local v0, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    iget-object v2, p0, Lorg/adaway/provider/AdAwayProvider;->mAdAwayDatabase:Lorg/adaway/provider/AdAwayDatabase;

    invoke-virtual {v2}, Lorg/adaway/provider/AdAwayDatabase;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 181
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-object v2, Lorg/adaway/provider/AdAwayProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v2, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v9

    .line 182
    .local v9, "match":I
    sparse-switch v9, :sswitch_data_86

    .line 196
    new-instance v2, Ljava/lang/UnsupportedOperationException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown uri: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 184
    :sswitch_5a
    const-string v2, "hosts_sources"

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    :goto_5f
    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v6, v5

    move-object v7, p5

    .line 199
    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 201
    .local v8, "cursor":Landroid/database/Cursor;
    invoke-virtual {p0}, Lorg/adaway/provider/AdAwayProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v8, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 202
    return-object v8

    .line 187
    .end local v8    # "cursor":Landroid/database/Cursor;
    :sswitch_74
    const-string v2, "whitelist"

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    goto :goto_5f

    .line 190
    :sswitch_7a
    const-string v2, "blacklist"

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    goto :goto_5f

    .line 193
    :sswitch_80
    const-string v2, "redirection_list"

    invoke-virtual {v0, v2}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    goto :goto_5f

    .line 182
    :sswitch_data_86
    .sparse-switch
        0x64 -> :sswitch_5a
        0xc8 -> :sswitch_74
        0x12c -> :sswitch_7a
        0x190 -> :sswitch_80
    .end sparse-switch
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .registers 12
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 210
    const-string v4, "AdAway"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "update(uri="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", values="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p2}, Landroid/content/ContentValues;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lorg/adaway/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    iget-object v4, p0, Lorg/adaway/provider/AdAwayProvider;->mAdAwayDatabase:Lorg/adaway/provider/AdAwayDatabase;

    invoke-virtual {v4}, Lorg/adaway/provider/AdAwayDatabase;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 214
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v0, 0x0

    .line 216
    .local v0, "count":I
    :try_start_33
    sget-object v4, Lorg/adaway/provider/AdAwayProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v4, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v3

    .line 217
    .local v3, "match":I
    sparse-switch v3, :sswitch_data_96

    .line 235
    new-instance v4, Ljava/lang/UnsupportedOperationException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unknown uri: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_55
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_33 .. :try_end_55} :catch_55

    .line 237
    .end local v3    # "match":I
    :catch_55
    move-exception v2

    .line 238
    .local v2, "e":Landroid/database/sqlite/SQLiteConstraintException;
    const-string v4, "AdAway"

    const-string v5, "Constraint exception on update! Entry already existing?"

    invoke-static {v4, v5}, Lorg/adaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 242
    .end local v2    # "e":Landroid/database/sqlite/SQLiteConstraintException;
    :goto_5d
    invoke-virtual {p0}, Lorg/adaway/provider/AdAwayProvider;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, p1, v5}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 244
    return v0

    .line 219
    .restart local v3    # "match":I
    :sswitch_6a
    :try_start_6a
    const-string v4, "hosts_sources"

    invoke-direct {p0, p1, p3}, Lorg/adaway/provider/AdAwayProvider;->buildDefaultSelection(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, p2, v5, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 221
    goto :goto_5d

    .line 223
    :sswitch_75
    const-string v4, "whitelist"

    invoke-direct {p0, p1, p3}, Lorg/adaway/provider/AdAwayProvider;->buildDefaultSelection(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, p2, v5, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 225
    goto :goto_5d

    .line 227
    :sswitch_80
    const-string v4, "blacklist"

    invoke-direct {p0, p1, p3}, Lorg/adaway/provider/AdAwayProvider;->buildDefaultSelection(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, p2, v5, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 229
    goto :goto_5d

    .line 231
    :sswitch_8b
    const-string v4, "redirection_list"

    invoke-direct {p0, p1, p3}, Lorg/adaway/provider/AdAwayProvider;->buildDefaultSelection(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, p2, v5, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_94
    .catch Landroid/database/sqlite/SQLiteConstraintException; {:try_start_6a .. :try_end_94} :catch_55

    move-result v0

    .line 233
    goto :goto_5d

    .line 217
    :sswitch_data_96
    .sparse-switch
        0x65 -> :sswitch_6a
        0xc9 -> :sswitch_75
        0x12d -> :sswitch_80
        0x191 -> :sswitch_8b
    .end sparse-switch
.end method
