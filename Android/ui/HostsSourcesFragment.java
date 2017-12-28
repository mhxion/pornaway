.class public Lorg/pornaway/ui/HostsSourcesFragment;
.super Lcom/actionbarsherlock/app/SherlockListFragment;
.source "HostsSourcesFragment.java"

# interfaces
.implements Landroid/support/v4/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/actionbarsherlock/app/SherlockListFragment;",
        "Landroid/support/v4/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# static fields
.field static final HOSTS_SOURCES_SUMMARY_PROJECTION:[Ljava/lang/String;


# instance fields
.field private mActivity:Landroid/app/Activity;

.field private mAdapter:Lorg/pornaway/util/HostsSourcesCursorAdapter;

.field private mCurrentRowId:J


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 336
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "url"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "enabled"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "last_modified_local"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "last_modified_online"

    aput-object v2, v0, v1

    sput-object v0, Lorg/pornaway/ui/HostsSourcesFragment;->HOSTS_SOURCES_SUMMARY_PROJECTION:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockListFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lorg/pornaway/ui/HostsSourcesFragment;)Landroid/app/Activity;
    .registers 2
    .param p0, "x0"    # Lorg/pornaway/ui/HostsSourcesFragment;

    .prologue
    .line 58
    iget-object v0, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$100(Lorg/pornaway/ui/HostsSourcesFragment;)J
    .registers 3
    .param p0, "x0"    # Lorg/pornaway/ui/HostsSourcesFragment;

    .prologue
    .line 58
    iget-wide v0, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mCurrentRowId:J

    return-wide v0
.end method

.method static synthetic access$200(Lorg/pornaway/ui/HostsSourcesFragment;Ljava/lang/String;)V
    .registers 2
    .param p0, "x0"    # Lorg/pornaway/ui/HostsSourcesFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lorg/pornaway/ui/HostsSourcesFragment;->addEntry(Ljava/lang/String;)V

    return-void
.end method

.method private addEntry(Ljava/lang/String;)V
    .registers 5
    .param p1, "input"    # Ljava/lang/String;

    .prologue
    .line 277
    if-eqz p1, :cond_d

    .line 278
    invoke-static {p1}, Lorg/pornaway/util/RegexUtils;->isValidUrl(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 281
    iget-object v1, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    invoke-static {v1, p1}, Lorg/pornaway/provider/ProviderHelper;->insertHostsSource(Landroid/content/Context;Ljava/lang/String;)V

    .line 297
    :cond_d
    :goto_d
    return-void

    .line 283
    :cond_e
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 284
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    const v1, 0x1080027

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setIcon(I)V

    .line 285
    const v1, 0x7f080065

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setTitle(I)V

    .line 286
    const v1, 0x7f080064

    invoke-virtual {p0, v1}, Lorg/pornaway/ui/HostsSourcesFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 287
    const v1, 0x7f08001a

    invoke-virtual {p0, v1}, Lorg/pornaway/ui/HostsSourcesFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lorg/pornaway/ui/HostsSourcesFragment$5;

    invoke-direct {v2, p0}, Lorg/pornaway/ui/HostsSourcesFragment$5;-><init>(Lorg/pornaway/ui/HostsSourcesFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog;->setButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 294
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_d
.end method

.method private menuDeleteEntry(Landroid/widget/AdapterView$AdapterContextMenuInfo;)V
    .registers 6
    .param p1, "info"    # Landroid/widget/AdapterView$AdapterContextMenuInfo;

    .prologue
    .line 111
    iget-wide v0, p1, Landroid/widget/AdapterView$AdapterContextMenuInfo;->id:J

    iput-wide v0, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mCurrentRowId:J

    .line 112
    iget-object v0, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    iget-wide v2, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mCurrentRowId:J

    invoke-static {v0, v2, v3}, Lorg/pornaway/provider/ProviderHelper;->deleteHostsSource(Landroid/content/Context;J)V

    .line 113
    return-void
.end method

.method private menuEditEntry(Landroid/widget/AdapterView$AdapterContextMenuInfo;)V
    .registers 14
    .param p1, "info"    # Landroid/widget/AdapterView$AdapterContextMenuInfo;

    .prologue
    .line 121
    iget-wide v10, p1, Landroid/widget/AdapterView$AdapterContextMenuInfo;->id:J

    iput-wide v10, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mCurrentRowId:J

    .line 122
    iget v6, p1, Landroid/widget/AdapterView$AdapterContextMenuInfo;->position:I

    .line 123
    .local v6, "position":I
    iget-object v8, p1, Landroid/widget/AdapterView$AdapterContextMenuInfo;->targetView:Landroid/view/View;

    .line 125
    .local v8, "v":Landroid/view/View;
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "url_"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 127
    .local v7, "urlTextView":Landroid/widget/TextView;
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v9, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    invoke-direct {v1, v9}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 128
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const/4 v9, 0x1

    invoke-virtual {v1, v9}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 129
    const v9, 0x7f08002e

    invoke-virtual {p0, v9}, Lorg/pornaway/ui/HostsSourcesFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 132
    iget-object v9, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    invoke-static {v9}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 133
    .local v3, "factory":Landroid/view/LayoutInflater;
    const v9, 0x7f040024

    const/4 v10, 0x0

    invoke-virtual {v3, v9, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 134
    .local v2, "dialogView":Landroid/view/View;
    const v9, 0x7f0e0059

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/EditText;

    .line 136
    .local v5, "inputEditText":Landroid/widget/EditText;
    invoke-virtual {v7}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v9

    invoke-virtual {v5, v9}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 137
    const/16 v9, 0x10

    invoke-virtual {v5, v9}, Landroid/widget/EditText;->setInputType(I)V

    .line 139
    invoke-virtual {v5}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    .line 140
    .local v4, "inputEditContent":Landroid/text/Editable;
    invoke-interface {v4}, Landroid/text/Editable;->length()I

    move-result v9

    invoke-virtual {v5, v9}, Landroid/widget/EditText;->setSelection(I)V

    .line 142
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 144
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v10, 0x7f080020

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    new-instance v10, Lorg/pornaway/ui/HostsSourcesFragment$1;

    invoke-direct {v10, p0, v5}, Lorg/pornaway/ui/HostsSourcesFragment$1;-><init>(Lorg/pornaway/ui/HostsSourcesFragment;Landroid/widget/EditText;)V

    invoke-virtual {v1, v9, v10}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 172
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v10, 0x7f080019

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    new-instance v10, Lorg/pornaway/ui/HostsSourcesFragment$2;

    invoke-direct {v10, p0}, Lorg/pornaway/ui/HostsSourcesFragment$2;-><init>(Lorg/pornaway/ui/HostsSourcesFragment;)V

    invoke-virtual {v1, v9, v10}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 180
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 181
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 182
    return-void
.end method


# virtual methods
.method public menuAddEntry()V
    .registers 9

    .prologue
    .line 231
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v6, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    invoke-direct {v1, v6}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 232
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const/4 v6, 0x1

    invoke-virtual {v1, v6}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 233
    const v6, 0x7f08002a

    invoke-virtual {p0, v6}, Lorg/pornaway/ui/HostsSourcesFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 236
    iget-object v6, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    invoke-static {v6}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 237
    .local v3, "factory":Landroid/view/LayoutInflater;
    const v6, 0x7f040024

    const/4 v7, 0x0

    invoke-virtual {v3, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 238
    .local v2, "dialogView":Landroid/view/View;
    const v6, 0x7f0e0059

    invoke-virtual {v2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/EditText;

    .line 240
    .local v5, "inputEditText":Landroid/widget/EditText;
    const v6, 0x7f0800db

    invoke-virtual {p0, v6}, Lorg/pornaway/ui/HostsSourcesFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 241
    const/16 v6, 0x10

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setInputType(I)V

    .line 243
    invoke-virtual {v5}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    .line 244
    .local v4, "inputEditContent":Landroid/text/Editable;
    invoke-interface {v4}, Landroid/text/Editable;->length()I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setSelection(I)V

    .line 246
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 248
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f080016

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lorg/pornaway/ui/HostsSourcesFragment$3;

    invoke-direct {v7, p0, v5}, Lorg/pornaway/ui/HostsSourcesFragment$3;-><init>(Lorg/pornaway/ui/HostsSourcesFragment;Landroid/widget/EditText;)V

    invoke-virtual {v1, v6, v7}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 259
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f080019

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lorg/pornaway/ui/HostsSourcesFragment$4;

    invoke-direct {v7, p0}, Lorg/pornaway/ui/HostsSourcesFragment$4;-><init>(Lorg/pornaway/ui/HostsSourcesFragment;)V

    invoke-virtual {v1, v6, v7}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 267
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 268
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 269
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .registers 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    const/4 v6, 0x0

    .line 304
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 306
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iput-object v0, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    .line 309
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->getListView()Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/pornaway/ui/HostsSourcesFragment;->registerForContextMenu(Landroid/view/View;)V

    .line 313
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const v1, 0x7f08002f

    invoke-virtual {p0, v1}, Lorg/pornaway/ui/HostsSourcesFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const v1, 0x7f080030

    .line 314
    invoke-virtual {p0, v1}, Lorg/pornaway/ui/HostsSourcesFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 313
    invoke-virtual {p0, v0}, Lorg/pornaway/ui/HostsSourcesFragment;->setEmptyText(Ljava/lang/CharSequence;)V

    .line 317
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lorg/pornaway/ui/HostsSourcesFragment;->setHasOptionsMenu(Z)V

    .line 320
    new-array v4, v6, [Ljava/lang/String;

    .line 321
    .local v4, "displayFields":[Ljava/lang/String;
    new-array v5, v6, [I

    .line 323
    .local v5, "displayViews":[I
    new-instance v0, Lorg/pornaway/util/HostsSourcesCursorAdapter;

    iget-object v1, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    const v2, 0x7f040018

    invoke-direct/range {v0 .. v6}, Lorg/pornaway/util/HostsSourcesCursorAdapter;-><init>(Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[II)V

    iput-object v0, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mAdapter:Lorg/pornaway/util/HostsSourcesCursorAdapter;

    .line 325
    iget-object v0, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mAdapter:Lorg/pornaway/util/HostsSourcesCursorAdapter;

    invoke-virtual {p0, v0}, Lorg/pornaway/ui/HostsSourcesFragment;->setListAdapter(Landroid/widget/ListAdapter;)V

    .line 328
    invoke-virtual {p0, v6}, Lorg/pornaway/ui/HostsSourcesFragment;->setListShown(Z)V

    .line 332
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v0

    invoke-virtual {v0, v6, v3, p0}, Landroid/support/v4/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 333
    return-void
.end method

.method public onContextItemSelected(Landroid/view/MenuItem;)Z
    .registers 5
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v1, 0x1

    .line 91
    invoke-interface {p1}, Landroid/view/MenuItem;->getMenuInfo()Landroid/view/ContextMenu$ContextMenuInfo;

    move-result-object v0

    check-cast v0, Landroid/widget/AdapterView$AdapterContextMenuInfo;

    .line 93
    .local v0, "info":Landroid/widget/AdapterView$AdapterContextMenuInfo;
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v2

    packed-switch v2, :pswitch_data_1c

    .line 101
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockListFragment;->onContextItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    :goto_12
    return v1

    .line 95
    :pswitch_13
    invoke-direct {p0, v0}, Lorg/pornaway/ui/HostsSourcesFragment;->menuDeleteEntry(Landroid/widget/AdapterView$AdapterContextMenuInfo;)V

    goto :goto_12

    .line 98
    :pswitch_17
    invoke-direct {p0, v0}, Lorg/pornaway/ui/HostsSourcesFragment;->menuEditEntry(Landroid/widget/AdapterView$AdapterContextMenuInfo;)V

    goto :goto_12

    .line 93
    nop

    :pswitch_data_1c
    .packed-switch 0x7f0e006c
        :pswitch_17
        :pswitch_13
    .end packed-switch
.end method

.method public onCreateContextMenu(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V
    .registers 6
    .param p1, "menu"    # Landroid/view/ContextMenu;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "menuInfo"    # Landroid/view/ContextMenu$ContextMenuInfo;

    .prologue
    .line 79
    invoke-super {p0, p1, p2, p3}, Lcom/actionbarsherlock/app/SherlockListFragment;->onCreateContextMenu(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V

    .line 80
    iget-object v1, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    .line 81
    invoke-virtual {v1}, Landroid/app/Activity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 82
    .local v0, "inflater":Landroid/view/MenuInflater;
    const v1, 0x7f08002d

    invoke-interface {p1, v1}, Landroid/view/ContextMenu;->setHeaderTitle(I)Landroid/view/ContextMenu;

    .line 83
    const v1, 0x7f0f0001

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 84
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .registers 10
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 344
    sget-object v2, Lorg/pornaway/provider/PornAwayContract$HostsSources;->CONTENT_URI:Landroid/net/Uri;

    .line 348
    .local v2, "baseUri":Landroid/net/Uri;
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v3, Lorg/pornaway/ui/HostsSourcesFragment;->HOSTS_SOURCES_SUMMARY_PROJECTION:[Ljava/lang/String;

    const-string v6, "url ASC"

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public onCreateOptionsMenu(Lcom/actionbarsherlock/view/Menu;Lcom/actionbarsherlock/view/MenuInflater;)V
    .registers 4
    .param p1, "menu"    # Lcom/actionbarsherlock/view/Menu;
    .param p2, "inflater"    # Lcom/actionbarsherlock/view/MenuInflater;

    .prologue
    .line 70
    invoke-super {p0, p1, p2}, Lcom/actionbarsherlock/app/SherlockListFragment;->onCreateOptionsMenu(Lcom/actionbarsherlock/view/Menu;Lcom/actionbarsherlock/view/MenuInflater;)V

    .line 71
    const v0, 0x7f0f0002

    invoke-virtual {p2, v0, p1}, Lcom/actionbarsherlock/view/MenuInflater;->inflate(ILcom/actionbarsherlock/view/Menu;)V

    .line 72
    return-void
.end method

.method public onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .registers 12
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 190
    invoke-super/range {p0 .. p5}, Lcom/actionbarsherlock/app/SherlockListFragment;->onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V

    .line 191
    iput-wide p4, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mCurrentRowId:J

    .line 195
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "checkbox_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    .line 197
    .local v0, "cBox":Landroid/widget/CheckBox;
    if-eqz v0, :cond_3e

    .line 198
    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v1

    if-eqz v1, :cond_33

    .line 199
    invoke-virtual {v0, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 201
    iget-object v1, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    iget-wide v2, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mCurrentRowId:J

    invoke-static {v1, v2, v3, v4}, Lorg/pornaway/provider/ProviderHelper;->updateHostsSourceEnabled(Landroid/content/Context;JZ)V

    .line 209
    :goto_32
    return-void

    .line 203
    :cond_33
    invoke-virtual {v0, v5}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 204
    iget-object v1, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mActivity:Landroid/app/Activity;

    iget-wide v2, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mCurrentRowId:J

    invoke-static {v1, v2, v3, v5}, Lorg/pornaway/provider/ProviderHelper;->updateHostsSourceEnabled(Landroid/content/Context;JZ)V

    goto :goto_32

    .line 207
    :cond_3e
    const-string v1, "PornAway"

    const-string v2, "Checkbox could not be found!"

    invoke-static {v1, v2}, Lorg/pornaway/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_32
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .registers 5
    .param p2, "data"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    const/4 v1, 0x1

    .line 356
    iget-object v0, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mAdapter:Lorg/pornaway/util/HostsSourcesCursorAdapter;

    invoke-virtual {v0, p2}, Lorg/pornaway/util/HostsSourcesCursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 359
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_10

    .line 360
    invoke-virtual {p0, v1}, Lorg/pornaway/ui/HostsSourcesFragment;->setListShown(Z)V

    .line 364
    :goto_f
    return-void

    .line 362
    :cond_10
    invoke-virtual {p0, v1}, Lorg/pornaway/ui/HostsSourcesFragment;->setListShownNoAnimation(Z)V

    goto :goto_f
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .registers 3

    .prologue
    .line 58
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p0, p1, p2}, Lorg/pornaway/ui/HostsSourcesFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/support/v4/content/Loader;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 371
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    iget-object v0, p0, Lorg/pornaway/ui/HostsSourcesFragment;->mAdapter:Lorg/pornaway/util/HostsSourcesCursorAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/pornaway/util/HostsSourcesCursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 372
    return-void
.end method

.method public onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z
    .registers 3
    .param p1, "item"    # Lcom/actionbarsherlock/view/MenuItem;

    .prologue
    .line 217
    invoke-interface {p1}, Lcom/actionbarsherlock/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_12

    .line 223
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockListFragment;->onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z

    move-result v0

    :goto_b
    return v0

    .line 219
    :pswitch_c
    invoke-virtual {p0}, Lorg/pornaway/ui/HostsSourcesFragment;->menuAddEntry()V

    .line 220
    const/4 v0, 0x1

    goto :goto_b

    .line 217
    nop

    :pswitch_data_12
    .packed-switch 0x7f0e006e
        :pswitch_c
    .end packed-switch
.end method
