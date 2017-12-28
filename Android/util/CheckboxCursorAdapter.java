.class public Lorg/pornaway/util/CheckboxCursorAdapter;
.super Landroid/support/v4/widget/SimpleCursorAdapter;
.source "CheckboxCursorAdapter.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[II)V
    .registers 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layout"    # I
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "from"    # [Ljava/lang/String;
    .param p5, "to"    # [I
    .param p6, "flags"    # I

    .prologue
    .line 37
    invoke-direct/range {p0 .. p6}, Landroid/support/v4/widget/SimpleCursorAdapter;-><init>(Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[II)V

    .line 38
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .registers 12
    .param p1, "v"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v7, 0x1

    .line 45
    const v6, 0x7f0e003e

    invoke-virtual {p1, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    .line 46
    .local v0, "cBox":Landroid/widget/CheckBox;
    if-eqz v0, :cond_37

    .line 48
    invoke-interface {p3}, Landroid/database/Cursor;->getPosition()I

    move-result v1

    .line 49
    .local v1, "cursorPosition":I
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v0, v6}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 52
    const-string v6, "enabled"

    invoke-interface {p3, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    .line 53
    .local v3, "enabledCol":I
    invoke-interface {p3, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 55
    .local v2, "enabled":Ljava/lang/String;
    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    if-ne v6, v7, :cond_38

    .line 56
    invoke-virtual {v0, v7}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 62
    :goto_2a
    const-string v6, "url"

    invoke-interface {p3, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v5

    .line 63
    .local v5, "hostnameCol":I
    invoke-interface {p3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 65
    .local v4, "hostname":Ljava/lang/String;
    invoke-virtual {v0, v4}, Landroid/widget/CheckBox;->setText(Ljava/lang/CharSequence;)V

    .line 67
    .end local v1    # "cursorPosition":I
    .end local v2    # "enabled":Ljava/lang/String;
    .end local v3    # "enabledCol":I
    .end local v4    # "hostname":Ljava/lang/String;
    .end local v5    # "hostnameCol":I
    :cond_37
    return-void

    .line 58
    .restart local v1    # "cursorPosition":I
    .restart local v2    # "enabled":Ljava/lang/String;
    .restart local v3    # "enabledCol":I
    :cond_38
    const/4 v6, 0x0

    invoke-virtual {v0, v6}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_2a
.end method
