# Azure Messages client library for Java
This package contains a Java SDK for Azure Communication Messages Services.

## Documentation

Various documentation is available to help you get started
- [Quick Start][azure_communication_messaging_qs]
- [API reference documentation][api_documentation]
- [Product documentation][product_docs]
- [Register WhatsApp Business Account][register_whatsapp_business_account]
- [WhatsApp Template Creation][create-manage-whatsapp-template]

## Getting started

### Prerequisites

- [Java Development Kit (JDK)](https://learn.microsoft.com/java/azure/jdk/?view=azure-java-stable) version 8 or above.
- [Apache Maven](https://maven.apache.org/download.cgi).
- You must have an [Azure subscription][azure_sub] to use this package.
- An existing Communication Services resource. If you need to create the resource, you can use the [Azure Portal][azure_portal], the [Azure PowerShell][azure_powershell], or the [Azure CLI][azure_cli].
- See [how to register whatsapp business account & create a channel][register_whatsapp_business_account] for registering whatsapp channel to your Communication Services resource.

### Adding the package to your product

Please include the azure-sdk-bom to your project to take dependency on the General Availability (GA) version of the library. In the following snippet, replace the {bom_version_to_target} placeholder with the version number.
To learn more about the BOM, see the [AZURE SDK BOM README](https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/boms/azure-sdk-bom/README.md).

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.azure</groupId>
            <artifactId>azure-sdk-bom</artifactId>
            <version>{bom_version_to_target}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
and then include the direct dependency in the dependencies section without the version tag.

```xml
<dependencies>
  <dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-communication-messages</artifactId>
  </dependency>
</dependencies>
```

#### Include direct dependency
If you want to take dependency on a particular version of the library that is not present in the BOM,
add the direct dependency to your project as follows.

[//]: # ({x-version-update-start;com.azure:azure-communication-messages;current})
```xml
<dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-communication-messages</artifactId>
    <version>1.2.0-beta.2</version>
</dependency>
```
[//]: # ({x-version-update-end})

## Key concepts

Then SDK provides two clients and each client can be async client or normal client:
- `NotificationMessageClient` or `NotificationMessageAsyncClient` provide operation to send message (text, media or template) and download media file from Whatsapp for given mediaId which we receive in incoming message event (User to Business Flow).
-  `MessageTemplateClient` or `MessageTemplateAsyncClient` provide operation to fetch template list for given channel.

### Authentication

You can get a key and/or connection string from your Communication Services resource in [Azure Portal][azure_portal]. Once you have a key, you may authenticate with any of the following methods:

### Using `a connection string`

```java readme-sample-createNotificationMessageClientWithConnectionString
NotificationMessagesClient notificationClient = new NotificationMessagesClientBuilder()
    .connectionString("<CONNECTION_STRING>")
    .buildClient();
```

```java readme-sample-createMessageTemplateClientWithConnectionString
MessageTemplateClient messageTemplateClient = new MessageTemplateClientBuilder()
    .connectionString("<CONNECTION_STRING>")
    .buildClient();
```
### Using `AzureKeyCredential`

```java readme-sample-createNotificationMessageClientWithAzureKeyCredential
String endpoint = "https://<resource-name>.communication.azure.com";
AzureKeyCredential azureKeyCredential = new AzureKeyCredential("<access-key>");
NotificationMessagesClient notificationClient = new NotificationMessagesClientBuilder()
    .endpoint(endpoint)
    .credential(azureKeyCredential)
    .buildClient();
```

```java readme-sample-createMessageTemplateClientWithAzureKeyCredential
String endpoint = "https://<resource-name>.communication.azure.com";
AzureKeyCredential azureKeyCredential = new AzureKeyCredential("<access-key>");
MessageTemplateClient messageTemplateClient = new MessageTemplateClientBuilder()
    .endpoint(endpoint)
    .credential(azureKeyCredential)
    .buildClient();
```

### Using `Azure Active Directory` managed identity

Client API key authentication is used in most of the examples, but you can also authenticate with Azure Active Directory using the [Azure Identity library][azure_identity]. To use the [DefaultAzureCredential][defaultazurecredential] provider shown below,

The `AZURE_CLIENT_SECRET`, `AZURE_CLIENT_ID`, and `AZURE_TENANT_ID` environment variables are needed to create a `DefaultAzureCredential` object.

```java readme-sample-createNotificationMessageClientWithAAD
String endpoint = "https://<resource-name>.communication.azure.com";
TokenCredential credential = new DefaultAzureCredentialBuilder().build();
NotificationMessagesClient notificationClient =  new NotificationMessagesClientBuilder()
    .endpoint(endpoint)
    .credential(credential)
    .buildClient();
```

```java readme-sample-createMessageTemplateClientWithAAD
String endpoint = "https://<resource-name>.communication.azure.com";
TokenCredential credential = new DefaultAzureCredentialBuilder().build();
MessageTemplateClient messageTemplateClient = new MessageTemplateClientBuilder()
    .endpoint(endpoint)
    .credential(credential)
    .buildClient();
```

## Examples

```java readme-sample-sendTemplateMessage
/*
* This sample shows how to send template message with below details
* Name: sample_shipping_confirmation, Language: en_US
*  [
      {
        "type": "BODY",
        "text": "Your package has been shipped. It will be delivered in {{1}} business days."
      },
      {
        "type": "FOOTER",
        "text": "This message is from an unverified business."
      }
    ]
* */
private void sendTemplateMessage() {

    //Update Template Name and language according your template associate to your channel.
    MessageTemplate template = new MessageTemplate("sample_shipping_confirmation", "en_US");

    //Update template parameter type and value
    List<MessageTemplateValue> messageTemplateValues = new ArrayList<>();
    messageTemplateValues.add(new MessageTemplateText("Days", "5"));
    template.setValues(messageTemplateValues);

    //Update template parameter binding
    List<WhatsAppMessageTemplateBindingsComponent> components = new ArrayList<>();
    components.add(new WhatsAppMessageTemplateBindingsComponent("Days"));
    MessageTemplateBindings bindings = new WhatsAppMessageTemplateBindings()
        .setBody(components);
    template.setBindings(bindings);

    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    SendMessageResult result = client.send(
        new TemplateNotificationContent("CHANNEL_ID", recipients, template));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```

```java readme-sample-sendTextMessage
/*
 * This sample shows how to send simple text message with below details
 * Note: Business cannot initiate conversation with text message.
 * */
private void sendTextMessage() {
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    SendMessageResult result = client.send(
        new TextNotificationContent("<CHANNEL_ID>", recipients, "Hello from ACS messaging"));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```

```java readme-sample-sendImageMessage
/*
 * This sample shows how to send image message with below details.
 * Supported image - image/jpeg (.jpeg), image/png (.png)
 * Note: Business cannot initiate conversation with media message.
 * */
public void sendImageMessage() {
    //Update the Media URL
    String mediaUrl = "https://wallpapercave.com/wp/wp2163723.jpg";
    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    SendMessageResult result = client.send(
        new ImageNotificationContent("<CHANNEL_ID>", recipients, mediaUrl));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```
```java readme-sample-sendVideoMessage
/*
 * This sample shows how to send video message with below details
 * Supported video - video/3gp (.3gp), video/mp4 (.mp4)
 * Note: Business cannot initiate conversation with media message.
 * */
public void sendVideoMessage() {
    //Update the Media URL
    String mediaUrl = "https://sample-videos.com/video321/mp4/480/big_buck_bunny_480p_1mb.mp4";
    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    SendMessageResult result = client.send(
        new VideoNotificationContent("<CHANNEL_ID>", recipients, mediaUrl));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```
```java readme-sample-sendAudioMessage
/*
 * This sample shows how to send audio message with below details
 * Supported audio - audio/aac (.aac), audio/amr (.amr), audio/mpeg (.mp3), audio/a4a (.mp4), audio/ogg (.ogg )
 * Note: Business cannot initiate conversation with media message.
 * */
public void sendAudioMessage() {
    //Update the Media URL
    String mediaUrl = "https://sample-videos.com/audio/mp3/wave.mp3";
    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    SendMessageResult result = client.send(
        new AudioNotificationContent("<CHANNEL_ID>", recipients, mediaUrl));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```
```java readme-sample-sendDocumentMessage
/*
 * This sample shows how to send document message with below details
 * Supported Document type - Plain Text (.txt), PDF (.pdf), Microsoft Excel, Word, PowerPoint
 * Note: Business cannot initiate conversation with media message.
 * */
public void sendDocumentMessage() {
    //Update the Media URL
    String mediaUrl = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    SendMessageResult result = client.send(
        new DocumentNotificationContent("<CHANNEL_ID>", recipients, mediaUrl));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```
```java readme-sample-sendStickerMessage
/*
 * This sample shows how to send sticker message with below details
 * Supported sticker type - (.webp)
 * Note: Business cannot initiate conversation with media message.
 * */
public static void sendStickerMessage() {
    //Update the Media URL
    String mediaUrl = "https://www.gstatic.com/webp/gallery/1.sm.webp";
    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    SendMessageResult result = client.send(
        new StickerNotificationContent("<CHANNEL_ID>", recipients, mediaUrl));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```
```java readme-sample-sendReactionMessage
/*
 * This sample shows how to send reaction message with below details
 * Emoji - unicode for emoji character.
 * Reply Message ID - ID of the message to be replied with emoji
 * Note: Business cannot initiate conversation with media message.
 * */
public static void sendReactionMessage() {
    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    SendMessageResult result = client.send(
        new ReactionNotificationContent("<CHANNEL_ID>", recipients, "\uD83D\uDE00", "<REPLY_MESSAGE_ID>"));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```
```java readme-sample-sendInteractiveMessageWithButtonAction
/*
 * This sample shows how to send interactive message with Button Action
 * Note: Business cannot initiate conversation with interactive message.
 * */
public void sendInteractiveMessageWithButtonAction() {
    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    List<ButtonContent> buttonActions =  new ArrayList<>();
    buttonActions.add(new ButtonContent("no",  "No"));
    buttonActions.add(new ButtonContent("yes",  "Yes"));
    ButtonSetContent buttonSet = new ButtonSetContent(buttonActions);
    InteractiveMessage interactiveMessage = new InteractiveMessage(
        new TextMessageContent("Do you want to proceed?"), new WhatsAppButtonActionBindings(buttonSet));
    SendMessageResult result = client.send(
        new InteractiveNotificationContent("<CHANNEL_ID>",  recipients, interactiveMessage));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```
```java readme-sample-sendInteractiveMessageWithListAction
/*
 * This sample shows how to send list action interactive message
 * Note: Business cannot initiate conversation with interactive message.
 * */
public static void sendInteractiveMessageWithListAction() {
    List<ActionGroupItem> group1 = new ArrayList<>();
    group1.add(new ActionGroupItem("priority_express", "Priority Mail Express", "Delivered on same day!"));
    group1.add(new ActionGroupItem("priority_mail", "Priority Mail", "Delivered in 1-2 days"));

    List<ActionGroupItem> group2 = new ArrayList<>();
    group2.add(new ActionGroupItem("usps_ground_advantage", "USPS Ground Advantage", "Delivered in 2-5 days"));
    group2.add(new ActionGroupItem("media_mail", "Media Mail", "Delivered in 5-8 days"));

    List<ActionGroup> options = new ArrayList<>();
    options.add(new ActionGroup("Express Delivery", group1));
    options.add(new ActionGroup("Normal Delivery", group2));

    ActionGroupContent actionGroupContent = new ActionGroupContent("Shipping Options", options);
    InteractiveMessage interactiveMessage = new InteractiveMessage(
        new TextMessageContent("Which shipping option do you want?"), new WhatsAppListActionBindings(actionGroupContent));
    interactiveMessage.setFooter(new TextMessageContent("Eagle Logistic"));
    interactiveMessage.setHeader(new TextMessageContent("Shipping Options"));

    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    SendMessageResult result = client.send(
        new InteractiveNotificationContent("<CHANNEL_ID>",  recipients, interactiveMessage));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));

}
```
```java readme-sample-sendInteractiveMessageWithUrlAction
/*
 * This sample shows how to send url action interactive message
 * Note: Business cannot initiate conversation with interactive message.
 * */
public static void sendInteractiveMessageWithUrlAction() {
    LinkContent urlAction = new LinkContent("Rocket is the best!", "https://wallpapercave.com/wp/wp2163723.jpg");
    InteractiveMessage interactiveMessage = new InteractiveMessage(
        new TextMessageContent("The best Guardian of Galaxy"), new WhatsAppUrlActionBindings(urlAction));
    interactiveMessage.setFooter(new TextMessageContent("Intergalactic New Ltd"));

    List<String> recipients = new ArrayList<>();
    recipients.add("<RECIPIENT_IDENTIFIER e.g. PhoneNumber>");
    NotificationMessagesClient client = new NotificationMessagesClientBuilder()
        .connectionString("<CONNECTION_STRING>")
        .buildClient();
    SendMessageResult result = client.send(
        new InteractiveNotificationContent("<CHANNEL_ID>",  recipients, interactiveMessage));

    result.getReceipts().forEach(r -> System.out.println("Message sent to:" + r.getTo() + " and message id:" + r.getMessageId()));
}
```

### Get Template List for given channel example:
```java readme-sample-ListTemplates
MessageTemplateClient templateClient =
    new MessageTemplateClientBuilder()
        .connectionString("<Connection_String>")
        .buildClient();

PagedIterable<MessageTemplateItem> response = templateClient.listTemplates("<CHANNEL_ID>");

response.stream().forEach(t -> {
    WhatsAppMessageTemplateItem template = (WhatsAppMessageTemplateItem) t;
    System.out.println("===============================");
    System.out.println("Template Name :: " + template.getName());
    System.out.println("Template Language :: " + template.getLanguage());
    System.out.println("Template Status :: " + template.getStatus());
    System.out.println("Template Content :: " + template.getContent());
    System.out.println("===============================");
});
```

## Troubleshooting
> More details coming soon,

## Next steps

- [Read more about Advance Messaging in Azure Communication Services][azure_communication_messaging_qs].
- Please take a look at the samples (src/samples) directory for detailed examples on how to use this library.


## Contributing

This project welcomes contributions and suggestions. Most contributions require you to agree to a [Contributor License Agreement (CLA)][cla] declaring that you have the right to, and actually do, grant us the rights to use your contribution.

When you submit a pull request, a CLA-bot will automatically determine whether you need to provide a CLA and decorate the PR appropriately (e.g., label, comment). Simply follow the instructions provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct][coc]. For more information see the [Code of Conduct FAQ][coc_faq] or contact [opencode@microsoft.com][coc_contact] with any additional questions or comments.


<!-- LINKS -->
[cla]: https://cla.microsoft.com
[coc]: https://opensource.microsoft.com/codeofconduct/
[coc_faq]: https://opensource.microsoft.com/codeofconduct/faq/
[coc_contact]: mailto:opencode@microsoft.com
[product_docs]: https://learn.microsoft.com/azure/communication-services/
[package]: https://central.sonatype.com/artifact/com.azure/azure-communication-messages
[api_documentation]: https://aka.ms/java-docs
[azure_communication_messaging_qs]: https://learn.microsoft.com/azure/communication-services/concepts/advanced-messaging/whatsapp/whatsapp-overview
[handle_advance_messaging_events]: https://learn.microsoft.com/azure/communication-services/quickstarts/advanced-messaging/whatsapp/handle-advanced-messaging-events
[register_whatsapp_business_account]: https://learn.microsoft.com/azure/communication-services/quickstarts/advanced-messaging/whatsapp/connect-whatsapp-business-account
[create-manage-whatsapp-template]: https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates/
[azure_identity]: https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/identity/azure-identity
[defaultazurecredential]: https://github.com/Azure/azure-sdk-for-js/tree/main/sdk/identity/identity#defaultazurecredential
[azure_cli]: https://learn.microsoft.com/cli/azure
[azure_sub]: https://azure.microsoft.com/free/
[azure_portal]: https://portal.azure.com
[azure_powershell]: https://learn.microsoft.com/powershell/module/az.communication/new-azcommunicationservice


