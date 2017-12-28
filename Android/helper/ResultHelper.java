.class public Lorg/pornaway/helper/ResultHelper;
.super Ljava/lang/Object;
.source "ResultHelper.java"


# static fields
.field private static final RESULT_NOTIFICATION_ID:I = 0x1e


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Landroid/content/Context;)V
    .registers 1
    .param p0, "x0"    # Landroid/content/Context;

    .prologue
    .line 42
    invoke-static {p0}, Lorg/pornaway/helper/ResultHelper;->tryToCreateSymlink(Landroid/content/Context;)V

    return-void
.end method

.method private static processResult(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V
    .registers 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "statusText"    # Ljava/lang/String;
    .param p4, "result"    # I
    .param p5, "iconStatus"    # I
    .param p6, "numberOfSuccessfulDownloads"    # Ljava/lang/String;
    .param p7, "showDialog"    # Z

    .prologue
    .line 326
    invoke-static {p0}, Lorg/pornaway/util/Utils;->isInForeground(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_44

    .line 327
    if-eqz p7, :cond_27

    .line 329
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lorg/pornaway/ui/BaseActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 330
    .local v0, "resultIntent":Landroid/content/Intent;
    const-string v1, "org.pornaway.APPLYING_RESULT"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 331
    if-eqz p6, :cond_1b

    .line 332
    const-string v1, "org.pornaway.NUMBER_OF_SUCCESSFUL_DOWNLOADS"

    invoke-virtual {v0, v1, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 335
    :cond_1b
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 336
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 337
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 344
    .end local v0    # "resultIntent":Landroid/content/Intent;
    :cond_27
    :goto_27
    if-eqz p6, :cond_48

    .line 345
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, p1, v1, p5}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    .line 350
    :goto_43
    return-void

    .line 341
    :cond_44
    invoke-static {p0, p1, p2, p4, p6}, Lorg/pornaway/helper/ResultHelper;->showResultNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    goto :goto_27

    .line 348
    :cond_48
    invoke-static {p0, p1, p3, p5}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_43
.end method

.method public static showDialogBasedOnResult(Landroid/content/Context;ILjava/lang/String;)V
    .registers 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "result"    # I
    .param p2, "numberOfSuccessfulDownloads"    # Ljava/lang/String;

    .prologue
    const v10, 0x7f080012

    const/4 v9, 0x6

    const/4 v8, 0x4

    const/4 v7, 0x3

    .line 163
    const/4 v6, 0x1

    if-ne p1, v6, :cond_3b

    .line 164
    if-eqz p2, :cond_37

    .line 165
    invoke-virtual {p0, v10}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 166
    .local v5, "title":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const v7, 0x7f080011

    invoke-virtual {p0, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 169
    .local v4, "text":Ljava/lang/String;
    invoke-static {p0, v5, v4, v8}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    .line 174
    .end local v4    # "text":Ljava/lang/String;
    .end local v5    # "title":Ljava/lang/String;
    :goto_30
    const v6, 0x7f0800a4

    invoke-static {p0, v10, v6}, Lorg/pornaway/util/Utils;->rebootQuestion(Landroid/content/Context;II)V

    .line 309
    :goto_36
    return-void

    .line 171
    :cond_37
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusEnabled(Landroid/content/Context;)V

    goto :goto_30

    .line 176
    :cond_3b
    const/16 v6, 0xe

    if-ne p1, v6, :cond_4c

    .line 177
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    .line 179
    const v6, 0x7f080087

    const v7, 0x7f0800b2

    invoke-static {p0, v6, v7}, Lorg/pornaway/util/Utils;->rebootQuestion(Landroid/content/Context;II)V

    goto :goto_36

    .line 181
    :cond_4c
    if-ne p1, v8, :cond_52

    .line 182
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusEnabled(Landroid/content/Context;)V

    goto :goto_36

    .line 183
    :cond_52
    const/4 v6, 0x5

    if-ne p1, v6, :cond_59

    .line 184
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    goto :goto_36

    .line 185
    :cond_59
    if-ne p1, v7, :cond_6d

    .line 186
    const v6, 0x7f080097

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 187
    .restart local v5    # "title":Ljava/lang/String;
    const v6, 0x7f080098

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 189
    .restart local v4    # "text":Ljava/lang/String;
    invoke-static {p0, v5, v4, v7}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_36

    .line 190
    .end local v4    # "text":Ljava/lang/String;
    .end local v5    # "title":Ljava/lang/String;
    :cond_6d
    const/16 v6, 0x9

    if-ne p1, v6, :cond_b2

    .line 191
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 192
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const v6, 0x7f080014

    invoke-virtual {v1, v6}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 193
    const v6, 0x7f0800a6

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 194
    const v6, 0x108009b

    invoke-virtual {v1, v6}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 195
    const v6, 0x7f080029

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lorg/pornaway/helper/ResultHelper$1;

    invoke-direct {v7, p0}, Lorg/pornaway/helper/ResultHelper$1;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1, v6, v7}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 202
    const v6, 0x7f08001d

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lorg/pornaway/helper/ResultHelper$2;

    invoke-direct {v7, p0}, Lorg/pornaway/helper/ResultHelper$2;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1, v6, v7}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 211
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v2

    .line 212
    .local v2, "question":Landroid/app/AlertDialog;
    invoke-virtual {v2}, Landroid/app/AlertDialog;->show()V

    goto :goto_36

    .line 214
    .end local v1    # "builder":Landroid/app/AlertDialog$Builder;
    .end local v2    # "question":Landroid/app/AlertDialog;
    :cond_b2
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 215
    .restart local v1    # "builder":Landroid/app/AlertDialog$Builder;
    const v6, 0x1080027

    invoke-virtual {v1, v6}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 216
    const v6, 0x7f08001a

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lorg/pornaway/helper/ResultHelper$3;

    invoke-direct {v7}, Lorg/pornaway/helper/ResultHelper$3;-><init>()V

    invoke-virtual {v1, v6, v7}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 223
    const v6, 0x7f08001c

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lorg/pornaway/helper/ResultHelper$4;

    invoke-direct {v7, p0}, Lorg/pornaway/helper/ResultHelper$4;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1, v6, v7}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 234
    const-string v5, ""

    .line 235
    .restart local v5    # "title":Ljava/lang/String;
    const-string v4, ""

    .line 236
    .restart local v4    # "text":Ljava/lang/String;
    const-string v3, ""

    .line 237
    .local v3, "statusText":Ljava/lang/String;
    packed-switch p1, :pswitch_data_1d4

    .line 302
    :goto_e4
    :pswitch_e4
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\n\n"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const v7, 0x7f08000b

    invoke-virtual {p0, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 303
    invoke-virtual {v1, v5}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 304
    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 306
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 307
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto/16 :goto_36

    .line 239
    .end local v0    # "alertDialog":Landroid/app/AlertDialog;
    :pswitch_111
    const v6, 0x7f08005a

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 240
    const v6, 0x7f080059

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 241
    const v6, 0x7f080094

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 243
    invoke-static {p0, v5, v3, v9}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_e4

    .line 247
    :pswitch_12a
    const v6, 0x7f080034

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 248
    const v6, 0x7f080033

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 249
    const v6, 0x7f080090

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 251
    invoke-static {p0, v5, v3, v9}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_e4

    .line 255
    :pswitch_143
    const v6, 0x7f080002

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 256
    const v6, 0x7f0800a1

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 258
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusEnabled(Landroid/content/Context;)V

    goto :goto_e4

    .line 261
    :pswitch_155
    const v6, 0x7f08000a

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 262
    const v6, 0x7f0800a2

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 264
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    goto/16 :goto_e4

    .line 267
    :pswitch_168
    const v6, 0x7f08000e

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 268
    const v6, 0x7f08000d

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 270
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    goto/16 :goto_e4

    .line 273
    :pswitch_17b
    const v6, 0x7f08000c

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 274
    const v6, 0x7f0800a3

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 276
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    goto/16 :goto_e4

    .line 279
    :pswitch_18e
    const v6, 0x7f080010

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 280
    const v6, 0x7f08000f

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 282
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    goto/16 :goto_e4

    .line 285
    :pswitch_1a1
    const v6, 0x7f080004

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 286
    const v6, 0x7f080003

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 288
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    goto/16 :goto_e4

    .line 291
    :pswitch_1b4
    const v6, 0x7f080086

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 292
    const v6, 0x7f080085

    invoke-virtual {p0, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 295
    sget-object v6, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-static {v6}, Lorg/pornaway/util/ApplyUtils;->isHostsFileCorrect(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1cf

    .line 296
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusEnabled(Landroid/content/Context;)V

    goto/16 :goto_e4

    .line 298
    :cond_1cf
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    goto/16 :goto_e4

    .line 237
    :pswitch_data_1d4
    .packed-switch 0x2
        :pswitch_168
        :pswitch_e4
        :pswitch_e4
        :pswitch_e4
        :pswitch_12a
        :pswitch_111
        :pswitch_155
        :pswitch_e4
        :pswitch_17b
        :pswitch_18e
        :pswitch_1a1
        :pswitch_e4
        :pswitch_e4
        :pswitch_1b4
        :pswitch_143
    .end packed-switch
.end method

.method public static showNotificationBasedOnResult(Landroid/content/Context;ILjava/lang/String;)V
    .registers 22
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "result"    # I
    .param p2, "numberOfSuccessfulDownloads"    # Ljava/lang/String;

    .prologue
    .line 55
    const/4 v1, 0x1

    move/from16 v0, p1

    if-ne v0, v1, :cond_49

    .line 56
    const v1, 0x7f080012

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 57
    .local v2, "title":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const v4, 0x7f080011

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, " "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p2

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 60
    .local v3, "text":Ljava/lang/String;
    const/4 v1, 0x4

    move-object/from16 v0, p0

    invoke-static {v0, v2, v3, v1}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    .line 63
    invoke-static/range {p0 .. p0}, Lorg/pornaway/helper/PreferenceHelper;->getNeverReboot(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_48

    .line 64
    const/4 v6, 0x4

    const/4 v8, 0x1

    move-object/from16 v1, p0

    move-object v4, v3

    move/from16 v5, p1

    move-object/from16 v7, p2

    invoke-static/range {v1 .. v8}, Lorg/pornaway/helper/ResultHelper;->processResult(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V

    .line 153
    .end local v2    # "title":Ljava/lang/String;
    .end local v3    # "text":Ljava/lang/String;
    :cond_48
    :goto_48
    return-void

    .line 67
    :cond_49
    const/16 v1, 0xe

    move/from16 v0, p1

    if-ne v0, v1, :cond_79

    .line 68
    const v1, 0x7f080087

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 69
    .restart local v2    # "title":Ljava/lang/String;
    const v1, 0x7f0800b2

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 71
    .restart local v3    # "text":Ljava/lang/String;
    const/4 v1, 0x5

    move-object/from16 v0, p0

    invoke-static {v0, v2, v3, v1}, Lorg/pornaway/ui/BaseActivity;->setStatusBroadcast(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V

    .line 74
    invoke-static/range {p0 .. p0}, Lorg/pornaway/helper/PreferenceHelper;->getNeverReboot(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_48

    .line 75
    const/4 v6, 0x5

    const/4 v7, 0x0

    const/4 v8, 0x1

    move-object/from16 v1, p0

    move-object v4, v3

    move/from16 v5, p1

    invoke-static/range {v1 .. v8}, Lorg/pornaway/helper/ResultHelper;->processResult(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V

    goto :goto_48

    .line 77
    .end local v2    # "title":Ljava/lang/String;
    .end local v3    # "text":Ljava/lang/String;
    :cond_79
    const/16 v1, 0xf

    move/from16 v0, p1

    if-ne v0, v1, :cond_a7

    .line 78
    const v1, 0x7f080086

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 79
    .restart local v2    # "title":Ljava/lang/String;
    const v1, 0x7f080085

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 83
    .restart local v3    # "text":Ljava/lang/String;
    sget-object v1, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-static {v1}, Lorg/pornaway/util/ApplyUtils;->isHostsFileCorrect(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_a5

    .line 84
    const/4 v6, 0x4

    .line 89
    .local v6, "oldStatus":I
    :goto_9a
    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object/from16 v1, p0

    move-object v4, v3

    move/from16 v5, p1

    invoke-static/range {v1 .. v8}, Lorg/pornaway/helper/ResultHelper;->processResult(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V

    goto :goto_48

    .line 86
    .end local v6    # "oldStatus":I
    :cond_a5
    const/4 v6, 0x5

    .restart local v6    # "oldStatus":I
    goto :goto_9a

    .line 90
    .end local v2    # "title":Ljava/lang/String;
    .end local v3    # "text":Ljava/lang/String;
    .end local v6    # "oldStatus":I
    :cond_a7
    const/4 v1, 0x3

    move/from16 v0, p1

    if-ne v0, v1, :cond_cd

    .line 91
    const v1, 0x7f080097

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 92
    .restart local v2    # "title":Ljava/lang/String;
    const v1, 0x7f080098

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 94
    .restart local v3    # "text":Ljava/lang/String;
    const/4 v12, 0x3

    const/4 v13, 0x0

    const/4 v14, 0x0

    move-object/from16 v7, p0

    move-object v8, v2

    move-object v9, v3

    move-object v10, v3

    move/from16 v11, p1

    invoke-static/range {v7 .. v14}, Lorg/pornaway/helper/ResultHelper;->processResult(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V

    goto/16 :goto_48

    .line 96
    .end local v2    # "title":Ljava/lang/String;
    .end local v3    # "text":Ljava/lang/String;
    :cond_cd
    const/16 v1, 0x10

    move/from16 v0, p1

    if-ne v0, v1, :cond_f4

    .line 97
    const v1, 0x7f080002

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 98
    .restart local v2    # "title":Ljava/lang/String;
    const v1, 0x7f0800a1

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 100
    .restart local v3    # "text":Ljava/lang/String;
    const/4 v12, 0x4

    const/4 v13, 0x0

    const/4 v14, 0x1

    move-object/from16 v7, p0

    move-object v8, v2

    move-object v9, v3

    move-object v10, v3

    move/from16 v11, p1

    invoke-static/range {v7 .. v14}, Lorg/pornaway/helper/ResultHelper;->processResult(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V

    goto/16 :goto_48

    .line 101
    .end local v2    # "title":Ljava/lang/String;
    .end local v3    # "text":Ljava/lang/String;
    :cond_f4
    const/4 v1, 0x6

    move/from16 v0, p1

    if-ne v0, v1, :cond_122

    .line 103
    const v1, 0x7f080034

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 104
    .restart local v2    # "title":Ljava/lang/String;
    const v1, 0x7f080033

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 105
    .restart local v3    # "text":Ljava/lang/String;
    const v1, 0x7f080090

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 107
    .local v10, "statusText":Ljava/lang/String;
    const/4 v12, 0x6

    const/4 v13, 0x0

    const/4 v14, 0x1

    move-object/from16 v7, p0

    move-object v8, v2

    move-object v9, v3

    move/from16 v11, p1

    invoke-static/range {v7 .. v14}, Lorg/pornaway/helper/ResultHelper;->processResult(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V

    goto/16 :goto_48

    .line 109
    .end local v2    # "title":Ljava/lang/String;
    .end local v3    # "text":Ljava/lang/String;
    .end local v10    # "statusText":Ljava/lang/String;
    :cond_122
    const/4 v1, 0x7

    move/from16 v0, p1

    if-ne v0, v1, :cond_150

    .line 111
    const v1, 0x7f08005a

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 112
    .restart local v2    # "title":Ljava/lang/String;
    const v1, 0x7f080059

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 113
    .restart local v3    # "text":Ljava/lang/String;
    const v1, 0x7f080094

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 115
    .restart local v10    # "statusText":Ljava/lang/String;
    const/4 v12, 0x6

    const/4 v13, 0x0

    const/4 v14, 0x0

    move-object/from16 v7, p0

    move-object v8, v2

    move-object v9, v3

    move/from16 v11, p1

    invoke-static/range {v7 .. v14}, Lorg/pornaway/helper/ResultHelper;->processResult(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V

    goto/16 :goto_48

    .line 117
    .end local v2    # "title":Ljava/lang/String;
    .end local v3    # "text":Ljava/lang/String;
    .end local v10    # "statusText":Ljava/lang/String;
    :cond_150
    const/4 v1, 0x4

    move/from16 v0, p1

    if-ne v0, v1, :cond_15a

    .line 118
    invoke-static/range {p0 .. p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusEnabled(Landroid/content/Context;)V

    goto/16 :goto_48

    .line 119
    :cond_15a
    const/4 v1, 0x5

    move/from16 v0, p1

    if-ne v0, v1, :cond_164

    .line 120
    invoke-static/range {p0 .. p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    goto/16 :goto_48

    .line 122
    :cond_164
    const-string v2, ""

    .line 123
    .restart local v2    # "title":Ljava/lang/String;
    const-string v3, ""

    .line 124
    .restart local v3    # "text":Ljava/lang/String;
    packed-switch p1, :pswitch_data_1f0

    .line 151
    :goto_16b
    :pswitch_16b
    const/16 v16, 0x5

    const/16 v17, 0x0

    const/16 v18, 0x1

    move-object/from16 v11, p0

    move-object v12, v2

    move-object v13, v3

    move-object v14, v3

    move/from16 v15, p1

    invoke-static/range {v11 .. v18}, Lorg/pornaway/helper/ResultHelper;->processResult(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Z)V

    goto/16 :goto_48

    .line 126
    :pswitch_17d
    const v1, 0x7f080014

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 127
    const v1, 0x7f0800a6

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 128
    goto :goto_16b

    .line 130
    :pswitch_190
    const v1, 0x7f08000a

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 131
    const v1, 0x7f0800a2

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 132
    goto :goto_16b

    .line 134
    :pswitch_1a3
    const v1, 0x7f08000e

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 135
    const v1, 0x7f08000d

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 136
    goto :goto_16b

    .line 138
    :pswitch_1b6
    const v1, 0x7f08000c

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 139
    const v1, 0x7f0800a3

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 140
    goto :goto_16b

    .line 142
    :pswitch_1c9
    const v1, 0x7f080010

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 143
    const v1, 0x7f08000f

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 144
    goto :goto_16b

    .line 146
    :pswitch_1dc
    const v1, 0x7f080004

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 147
    const v1, 0x7f080003

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_16b

    .line 124
    :pswitch_data_1f0
    .packed-switch 0x2
        :pswitch_1a3
        :pswitch_16b
        :pswitch_16b
        :pswitch_16b
        :pswitch_16b
        :pswitch_16b
        :pswitch_190
        :pswitch_17d
        :pswitch_1b6
        :pswitch_1c9
        :pswitch_1dc
    .end packed-switch
.end method

.method private static showResultNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    .registers 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "contentTitle"    # Ljava/lang/String;
    .param p2, "contentText"    # Ljava/lang/String;
    .param p3, "applyingResult"    # I
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 360
    .line 361
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-string v8, "notification"

    invoke-virtual {v5, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/app/NotificationManager;

    .line 363
    .local v4, "notificationManager":Landroid/app/NotificationManager;
    const v1, 0x7f020085

    .line 364
    .local v1, "icon":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 367
    .local v6, "when":J
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const/high16 v8, 0x7f080000

    invoke-virtual {p0, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, ": "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 369
    new-instance v5, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v5, p0}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 370
    invoke-virtual {v5, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    invoke-virtual {v5, v6, v7}, Landroid/support/v4/app/NotificationCompat$Builder;->setWhen(J)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    const/4 v8, 0x1

    invoke-virtual {v5, v8}, Landroid/support/v4/app/NotificationCompat$Builder;->setAutoCancel(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    invoke-virtual {v5, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v5

    .line 371
    invoke-virtual {v5, p2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v2

    .line 373
    .local v2, "mBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    new-instance v3, Landroid/content/Intent;

    const-class v5, Lorg/pornaway/ui/BaseActivity;

    invoke-direct {v3, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 376
    .local v3, "notificationIntent":Landroid/content/Intent;
    const-string v5, "org.pornaway.APPLYING_RESULT"

    invoke-virtual {v3, v5, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 377
    const-string v5, "org.pornaway.NUMBER_OF_SUCCESSFUL_DOWNLOADS"

    invoke-virtual {v3, v5, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 379
    const/4 v5, 0x0

    const/high16 v8, 0x8000000

    invoke-static {p0, v5, v3, v8}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 382
    .local v0, "contentIntent":Landroid/app/PendingIntent;
    invoke-virtual {v2, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 384
    const/16 v5, 0x1e

    invoke-virtual {v2}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v8

    invoke-virtual {v4, v5, v8}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 385
    return-void
.end method

.method private static tryToCreateSymlink(Landroid/content/Context;)V
    .registers 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 391
    const/4 v3, 0x1

    .line 395
    .local v3, "success":Z
    :try_start_1
    invoke-static {p0}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "writeToDataData"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2f

    .line 396
    sget-object v4, Lorg/pornaway/util/Constants;->ANDROID_DATA_DATA_HOSTS:Ljava/lang/String;

    invoke-static {v4}, Lorg/pornaway/util/ApplyUtils;->createSymlink(Ljava/lang/String;)V
    :try_end_12
    .catch Lorg/pornaway/util/CommandException; {:try_start_1 .. :try_end_12} :catch_41
    .catch Lorg/pornaway/util/RemountException; {:try_start_1 .. :try_end_12} :catch_5f

    .line 412
    :cond_12
    :goto_12
    if-eqz v3, :cond_1a

    .line 413
    sget-object v4, Lorg/pornaway/util/Constants;->ANDROID_SYSTEM_ETC_HOSTS:Ljava/lang/String;

    invoke-static {v4}, Lorg/pornaway/util/ApplyUtils;->isHostsFileCorrect(Ljava/lang/String;)Z

    move-result v3

    .line 416
    :cond_1a
    if-eqz v3, :cond_69

    .line 417
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusEnabled(Landroid/content/Context;)V

    .line 419
    invoke-static {p0}, Lorg/pornaway/helper/PreferenceHelper;->getNeverReboot(Landroid/content/Context;)Z

    move-result v4

    if-nez v4, :cond_2e

    .line 420
    const v4, 0x7f080015

    const v5, 0x7f0800a7

    invoke-static {p0, v4, v5}, Lorg/pornaway/util/Utils;->rebootQuestion(Landroid/content/Context;II)V

    .line 451
    :cond_2e
    :goto_2e
    return-void

    .line 397
    :cond_2f
    :try_start_2f
    invoke-static {p0}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "writeToData"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4b

    .line 398
    sget-object v4, Lorg/pornaway/util/Constants;->ANDROID_DATA_HOSTS:Ljava/lang/String;

    invoke-static {v4}, Lorg/pornaway/util/ApplyUtils;->createSymlink(Ljava/lang/String;)V
    :try_end_40
    .catch Lorg/pornaway/util/CommandException; {:try_start_2f .. :try_end_40} :catch_41
    .catch Lorg/pornaway/util/RemountException; {:try_start_2f .. :try_end_40} :catch_5f

    goto :goto_12

    .line 402
    :catch_41
    move-exception v2

    .line 403
    .local v2, "e":Lorg/pornaway/util/CommandException;
    const-string v4, "PornAway"

    const-string v5, "CommandException"

    invoke-static {v4, v5, v2}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 405
    const/4 v3, 0x0

    .line 410
    goto :goto_12

    .line 399
    .end local v2    # "e":Lorg/pornaway/util/CommandException;
    :cond_4b
    :try_start_4b
    invoke-static {p0}, Lorg/pornaway/helper/PreferenceHelper;->getApplyMethod(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "customTarget"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_12

    .line 400
    invoke-static {p0}, Lorg/pornaway/helper/PreferenceHelper;->getCustomTarget(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lorg/pornaway/util/ApplyUtils;->createSymlink(Ljava/lang/String;)V
    :try_end_5e
    .catch Lorg/pornaway/util/CommandException; {:try_start_4b .. :try_end_5e} :catch_41
    .catch Lorg/pornaway/util/RemountException; {:try_start_4b .. :try_end_5e} :catch_5f

    goto :goto_12

    .line 406
    :catch_5f
    move-exception v2

    .line 407
    .local v2, "e":Lorg/pornaway/util/RemountException;
    const-string v4, "PornAway"

    const-string v5, "RemountException"

    invoke-static {v4, v5, v2}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 409
    const/4 v3, 0x0

    goto :goto_12

    .line 424
    .end local v2    # "e":Lorg/pornaway/util/RemountException;
    :cond_69
    invoke-static {p0}, Lorg/pornaway/ui/BaseActivity;->updateStatusDisabled(Landroid/content/Context;)V

    .line 426
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 427
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const v4, 0x7f080013

    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 428
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const v5, 0x7f0800a5

    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const v5, 0x7f08000b

    .line 429
    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 428
    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 430
    const v4, 0x1080027

    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 431
    const v4, 0x7f08001a

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lorg/pornaway/helper/ResultHelper$5;

    invoke-direct {v5}, Lorg/pornaway/helper/ResultHelper$5;-><init>()V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 438
    const v4, 0x7f08001c

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lorg/pornaway/helper/ResultHelper$6;

    invoke-direct {v5, p0}, Lorg/pornaway/helper/ResultHelper$6;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 448
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 449
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto/16 :goto_2e
.end method
