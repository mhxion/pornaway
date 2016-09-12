.class public Lorg/adaway/provider/AdAwayDatabase;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "AdAwayDatabase.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/adaway/provider/AdAwayDatabase$Tables;
    }
.end annotation


# static fields
.field private static final CREATE_BLACKLIST:Ljava/lang/String; = "CREATE TABLE IF NOT EXISTS blacklist(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, enabled INTEGER)"

.field private static final CREATE_HOSTS_SOURCES:Ljava/lang/String; = "CREATE TABLE IF NOT EXISTS hosts_sources(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, last_modified_local INTEGER, last_modified_online INTEGER, enabled INTEGER)"

.field private static final CREATE_REDIRECTION_LIST:Ljava/lang/String; = "CREATE TABLE IF NOT EXISTS redirection_list(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, ip TEXT, enabled INTEGER)"

.field private static final CREATE_WHITELIST:Ljava/lang/String; = "CREATE TABLE IF NOT EXISTS whitelist(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, enabled INTEGER)"

.field private static final DATABASE_NAME:Ljava/lang/String; = "adaway.db"

.field private static final DATABASE_VERSION:I = 0xe


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .registers 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 68
    const-string v0, "adaway.db"

    const/4 v1, 0x0

    const/16 v2, 0xe

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 69
    return-void
.end method

.method private insertDefaultHostsSources(Landroid/database/sqlite/SQLiteDatabase;)V
    .registers 5
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 82
    const-string v0, "INSERT OR IGNORE INTO hosts_sources(url, last_modified_local, last_modified_online, enabled) VALUES (?, ?, ?, ?)"

    .line 84
    .local v0, "insertHostsSources":Ljava/lang/String;
    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v1

    .line 87
    .local v1, "insertStmt":Landroid/database/sqlite/SQLiteStatement;
    const-string v2, "https://www.mywikis.com/clearcloud/files/youngtiger/pornaway.txt"

    invoke-virtual {p0, v1, v2}, Lorg/adaway/provider/AdAwayDatabase;->insertHostsSource(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/String;)J

    .line 90
    const-string v2, "https://www.mywikis.com/clearcloud/files/pornaway/hosts.txt"

    invoke-virtual {p0, v1, v2}, Lorg/adaway/provider/AdAwayDatabase;->insertHostsSource(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/String;)J

    .line 93
    const-string v2, "https://www.mywikis.com/clearcloud/files/youngtiger/pornaway_alt.txt"

    invoke-virtual {p0, v1, v2}, Lorg/adaway/provider/AdAwayDatabase;->insertHostsSource(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/String;)J

    .line 97
    const-string v2, "https://www.mywikis.com/clearcloud/files/pornaway/hosts_alt.txt"

    invoke-virtual {p0, v1, v2}, Lorg/adaway/provider/AdAwayDatabase;->insertHostsSource(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/String;)J

    .line 98
    return-void
.end method


# virtual methods
.method public insertHostsSource(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/String;)J
    .registers 7
    .param p1, "insertStmt"    # Landroid/database/sqlite/SQLiteStatement;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const-wide/16 v2, 0x0

    .line 72
    const/4 v0, 0x1

    invoke-virtual {p1, v0, p2}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 73
    const/4 v0, 0x2

    invoke-virtual {p1, v0, v2, v3}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 74
    const/4 v0, 0x3

    invoke-virtual {p1, v0, v2, v3}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 75
    const/4 v0, 0x4

    const-string v1, "1"

    invoke-virtual {p1, v0, v1}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 76
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteStatement;->executeInsert()J

    move-result-wide v0

    return-wide v0
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .registers 4
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 102
    const-string v0, "AdAway"

    const-string v1, "Creating database..."

    invoke-static {v0, v1}, Lorg/adaway/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    const-string v0, "CREATE TABLE IF NOT EXISTS hosts_sources(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, last_modified_local INTEGER, last_modified_online INTEGER, enabled INTEGER)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 105
    const-string v0, "CREATE TABLE IF NOT EXISTS whitelist(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, enabled INTEGER)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 106
    const-string v0, "CREATE TABLE IF NOT EXISTS blacklist(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, enabled INTEGER)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 107
    const-string v0, "CREATE TABLE IF NOT EXISTS redirection_list(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, ip TEXT, enabled INTEGER)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 109
    invoke-direct {p0, p1}, Lorg/adaway/provider/AdAwayDatabase;->insertDefaultHostsSources(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 110
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .registers 7
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 114
    const-string v0, "AdAway"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Upgrading database from version "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/adaway/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    const/4 v0, 0x1

    if-gt p2, v0, :cond_34

    .line 118
    const-string v0, "CREATE TABLE IF NOT EXISTS whitelist(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, enabled INTEGER)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 119
    const-string v0, "CREATE TABLE IF NOT EXISTS blacklist(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, enabled INTEGER)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 120
    const-string v0, "CREATE TABLE IF NOT EXISTS redirection_list(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT UNIQUE, ip TEXT, enabled INTEGER)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 127
    :cond_34
    const/4 v0, 0x3

    if-gt p2, v0, :cond_50

    .line 131
    const-string v0, "UPDATE hosts_sources SET url=\"https://www.mywikis.com/clearcloud/files/youngtiger/pornaway.txt\" WHERE url=\"https://www.mywikis.com/clearcloud/files/youngtiger/pornaway.txt\""

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 135
    const-string v0, "INSERT OR IGNORE INTO hosts_sources (url, enabled) VALUES (\"http://sysctl.org/cameleon/hosts\", 1)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 138
    const-string v0, "DROP TABLE IF EXISTS last_modified"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 140
    const-string v0, "ALTER TABLE hosts_sources ADD COLUMN last_modified_local"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 141
    const-string v0, "ALTER TABLE hosts_sources ADD COLUMN last_modified_online"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 143
    :cond_50
    const/4 v0, 0x4

    if-gt p2, v0, :cond_5d

    .line 145
    const-string v0, "DELETE FROM hosts_sources WHERE url=\"http://sysctl.org/cameleon/hosts\""

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 148
    const-string v0, "INSERT OR IGNORE INTO hosts_sources (url, last_modified_local, last_modified_online, enabled) VALUES (\"https://www.mywikis.com/clearcloud/files/youngtiger/pornaway_alt.txt\", 0, 0, 1)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 152
    :cond_5d
    const/4 v0, 0x5

    if-gt p2, v0, :cond_65

    .line 154
    const-string v0, "INSERT OR IGNORE INTO hosts_sources (url, last_modified_local, last_modified_online, enabled) VALUES (\"http://www.ismeh.com/HOSTS\", 0, 0, 1)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 158
    :cond_65
    const/4 v0, 0x6

    if-gt p2, v0, :cond_72

    .line 160
    const-string v0, "DELETE FROM hosts_sources WHERE url=\"http://www.ismeh.com/HOSTS\""

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 163
    const-string v0, "INSERT OR IGNORE INTO hosts_sources (url, last_modified_local, last_modified_online, enabled) VALUES (\"http://adaway.sufficientlysecure.org/hosts.txt\", 0, 0, 1)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 167
    :cond_72
    const/4 v0, 0x7

    if-gt p2, v0, :cond_7a

    .line 169
    const-string v0, "UPDATE hosts_sources SET url=\"https://www.mywikis.com/clearcloud/files/pornaway/hosts_alt.txt\" WHERE url=\"https://www.mywikis.com/clearcloud/files/pornaway/hosts_alt.txt\""

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 173
    :cond_7a
    const/16 v0, 0x8

    if-gt p2, v0, :cond_88

    .line 177
    const-string v0, "DELETE FROM hosts_sources WHERE url IN (\"https://www.mywikis.com/clearcloud/files/pornaway/hosts_alt.txt\", \"https://www.mywikis.com/clearcloud/files/pornaway/hosts_alt.txt\")"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 180
    const-string v0, "INSERT INTO hosts_sources (url, last_modified_local, last_modified_online, enabled) VALUES (\"https://www.mywikis.com/clearcloud/files/pornaway/hosts_alt.txt\", 0, 0, 1)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 184
    :cond_88
    const/16 v0, 0xa

    if-gt p2, v0, :cond_96

    .line 187
    const-string v0, "DELETE FROM hosts_sources WHERE url IN (\"https://www.mywikis.com/clearcloud/files/pornaway/hosts_alt.txt\", \"https://www.mywikis.com/clearcloud/files/pornaway/hosts_alt.txt\")"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 190
    const-string v0, "INSERT INTO hosts_sources (url, last_modified_local, last_modified_online, enabled) VALUES (\"https://www.mywikis.com/clearcloud/files/youngtiger/pornaway.txt\", 0, 0, 1)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 194
    :cond_96
    const/16 v0, 0xb

    if-gt p2, v0, :cond_9f

    .line 196
    const-string v0, "UPDATE hosts_sources SET url=\"https://www.mywikis.com/clearcloud/files/pornaway/hosts.txt\" WHERE url=\"https://www.mywikis.com/clearcloud/files/pornaway/hosts.txt\""

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 200
    :cond_9f
    const/16 v0, 0xc

    if-gt p2, v0, :cond_a8

    .line 202
    const-string v0, "UPDATE hosts_sources SET url=\"https://www.mywikis.com/clearcloud/files/youngtiger/pornaway_alt.txt\" WHERE url=\"https://www.mywikis.com/clearcloud/files/youngtiger/pornaway_alt.txt\""

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 206
    :cond_a8
    const/16 v0, 0xd

    if-gt p2, v0, :cond_b2

    .line 208
    const-string v0, "UPDATE hosts_sources SET url=\"https://www.mywikis.com/clearcloud/files/pornaway/hosts.txt\" WHERE url=\"https://www.mywikis.com/clearcloud/files/pornaway/hosts.txt\""

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 218
    :goto_b1
    return-void

    .line 212
    :cond_b2
    const-string v0, "DROP TABLE IF EXISTS hosts_sources"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 213
    const-string v0, "DROP TABLE IF EXISTS whitelist"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 214
    const-string v0, "DROP TABLE IF EXISTS blacklist"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 215
    const-string v0, "DROP TABLE IF EXISTS redirection_list"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 216
    invoke-virtual {p0, p1}, Lorg/adaway/provider/AdAwayDatabase;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    goto :goto_b1
.end method
