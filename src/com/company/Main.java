package com.company;

import java.text.DateFormat;
import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Contact contact1 = new Contact("Alex", "+380661234561");
        Contact contact2 = new Contact("Dasha", "+380661234562");
        Contact contact3 = new Contact("Oleg", "+380661234563");
        Contact contact4 = new Contact("Ira", "+380661234564");
        Contact contact5 = new Contact("Maks", "+380661234565");
        Contact contact6 = new Contact("Misha", "+380661234566");

        Collection<Contact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);
        contacts.add(contact6);
        System.out.println("Выводим коллекцию контактов");
        printContacts(contacts);
        System.out.println("Выполняем поиск по коллекции контактов");
        Collection<Contact> foundContacts = findContacts(contacts, "a");
        System.out.println("Выводим коллекцию найденных контактов по задданому поиску");
        printContacts(foundContacts);


        List<CallLog> callLogs = new ArrayList<>();
        callLogs.add(new CallLog("+380661234561", 120, new Date()));
        callLogs.add(new CallLog("+380661234561", 2320, new Date()));
        callLogs.add(new CallLog("+380661234561", 1120, new Date()));
        callLogs.add(new CallLog("+380661234561", 70, new Date()));
        callLogs.add(new CallLog("+380661234562", 6420, new Date()));
        callLogs.add(new CallLog("+380661234562", 10, new Date()));
        callLogs.add(new CallLog("+380661234563", 1720, new Date()));
        callLogs.add(new CallLog("+380661234564", 50, new Date()));
        callLogs.add(new CallLog("+380661234564", 65, new Date()));
        callLogs.add(new CallLog("+380661234564", 720, new Date()));
        callLogs.add(new CallLog("+380661234565", 920, new Date()));
        callLogs.add(new CallLog("+380661234565", 63, new Date()));
        callLogs.add(new CallLog("+380661234566", 15, new Date()));

        System.out.println("Выводим коллекцию звонков ");
        printCallLog(callLogs);
        System.out.println("Выполняем поиск по коллекции звонков ");
        Collection<CallLog> foundCallLog = findCalls(callLogs, "63");
        System.out.println("Выводим коллекцию найденных звонков по задданому поиску");
        printCallLog(foundCallLog);


        List<Message> messages = new ArrayList<>();
        messages.add(new Message("+380661234561", "Hey", new Date()));
        messages.add(new Message("+380661234561", "Hey", new Date()));
        messages.add(new Message("+380661234561", "How are you?", new Date()));
        messages.add(new Message("+380661234562", "Hello", new Date()));
        messages.add(new Message("+380661234562", "Sos", new Date()));
        messages.add(new Message("+380661234562", "Ky", new Date()));
        messages.add(new Message("+380661234563", "Good morning", new Date()));
        messages.add(new Message("+380661234563", "sup", new Date()));
        messages.add(new Message("+380661234563", "true", new Date()));
        messages.add(new Message("+380661234563", "Good day", new Date()));
        messages.add(new Message("+380661234564", "Hello", new Date()));
        messages.add(new Message("+380661234564", ":)", new Date()));
        messages.add(new Message("+380661234564", "Nice to meet you", new Date()));
        messages.add(new Message("+380661234565", "Sos", new Date()));
        messages.add(new Message("+380661234566", "Bye", new Date()));
        messages.add(new Message("+380661234566", "Good morning", new Date()));

        System.out.println("Выводим коллекцию сообщений ");
        printMassage(messages);
        System.out.println("Выполняем поиск по коллекции сообщений");
        Collection<Message> foundMassage = findMessage(messages, "62");
        System.out.println("Выводим коллекцию найденных сообщений по задданому поиску");
        printMassage(foundMassage);

        System.out.println("");

        Map<String, Contact> mapContact = mapContactsToPhoneNumber(contacts);
        System.out.println("");

        Map<String, List<CallLog>> groupCalls = groupCalls(callLogs);
        System.out.println("Выводим сгруппированные по контактам звонки");
        printGroupCalls(mapContact, groupCalls);

        Map<String, List<Message>> groupMessage = groupMessage(messages);
        System.out.println("Выводим сгруппированные по контактам сообщения");
        printGroupMessage(mapContact, groupMessage);

        System.out.println("------------------------------------------------------------");
        System.out.println("Выводим топ - 5 контактов  с наибольшим количеством звонков");
        printTop5Contacts(sortTopCallsContacts(mapContact, groupCalls));
        System.out.println("------------------------------------------------------");
        System.out.println("Выводим топ - 5 контактов  с наибольшим количеством сообщений");
        printTop5Contacts(sortTopMessageContacts(mapContact, groupMessage));
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Выводим топ - 5 контактов  с наибольшей суммарной длительностью звонков");
        printTop5Contacts(sortTopDurations(mapContact, groupCalls));
        System.out.println("____________________________________________________");
        Set<Contact> uniqueContact = new HashSet<>(contacts);
        System.out.println("Выводим уникальные элементы в коллекции контактов");
        printSetContact(uniqueContact);
        System.out.println("---------------------------------------------------");

        Set<CallLog> uniqueCall = new HashSet<>(callLogs);
        System.out.println("Выводим уникальные элементы в коллекции звонков");
        printSetCall(uniqueCall);
        System.out.println("---");

        Set<Message> uniqueMessage = new HashSet<>(messages);
        System.out.println("Выводим уникальные элементы в коллекции сообщений");
        printSetMessage(uniqueMessage);
        System.out.println("");

        System.out.println("");
        System.out.println("Преобразуем коллекцию контактов в массив и выводим его");
        Contact[] arrayContacts = contacts.toArray(new Contact[0]);
        printArray(arrayContacts);
        System.out.println("");
        System.out.println("Преобразуем коллекцию сообщений в массив и выводим его");
        Message[] arrayMessages = messages.toArray(new Message[0]);
        printArray(arrayMessages);
        System.out.println("");
        System.out.println("Преобразуем коллекцию звонков  в массив и выводим его");
        CallLog[] arrayCalls = callLogs.toArray(new CallLog[0]);
        printArray(arrayCalls);

        System.out.println("_______________________________________________________________________________");
        printQueueLIFO(gettingQueueLIFO(contacts));
        System.out.println("________________________________________________________________________");
        printQueueFIFO(gettingQueueFIFO(contacts));
        printQueueFIFO(gettingQueueFIFO(messages));
        System.out.println("________________________________________________________________________");
        printQueueLIFO(gettingQueueLIFO(messages));


    }


    private static <T> void printArray(T[] array){
        for (T t : array) {
            System.out.println(t);
        }
    }
    private static <E> Collection<E> filterCollection(Collection <E> collection, Predicate<E> predicate) {
        Collection<E> result = new ArrayList<>();
    for(E collection1 : collection){
            if (predicate.test(collection1)) {
                result.add(collection1);
            }
        } return result;
    }


    private static <E> Deque<E> gettingQueueFIFO (Collection <E> collections){
        Deque<E> result = new ArrayDeque<E>();
        for (E collection: collections){
            result.offer(collection);
        }
        return result;
    }

    private static <E> void printQueueFIFO (Deque<E> result){
        while(result.peek()!=null){
            // извлечение c начала
            System.out.println(result.poll());
        }
    }
    private static <U> Deque<U> gettingQueueLIFO (Collection <U> collections){
        Deque<U> result = new ArrayDeque<U>();
        for (U collection: collections){
            result.add(collection);
        }
        return result;
    }

    private static <U> void printQueueLIFO (Deque<U> result){
        while(result.peek()!=null){
            // извлечение c начала
            System.out.println(result.pollLast());
        }
    }

    /**
     * This method outputs set with unique elements in the Collection <Contact>
     *
     * @param contacts - Set<Contact>
     */
    private static void printSetContact(Set<Contact> contacts) {
        for (Contact contact : contacts) {
            String output = String.format(Locale.ROOT, "Name of contact %s, his number -  %s", contact.name, contact.phoneNumber);
            System.out.println(output);
        }
    }

    /**
     * This method outputs set with unique elements in the Collection <CallLog>
     *
     * @param calls - Set<CallLog>
     */
    private static void printSetCall(Set<CallLog> calls) {
        for (CallLog callLog : calls) {
            int minutes = callLog.duration / 60;
            int seconds = callLog.duration % 60;
            String output = String.format(Locale.ROOT, "Call to %s, duration -  %dm %ds at - %s", callLog.remotePhoneNumber, minutes, seconds, callLog.startDate.toString());
            System.out.println(output);
        }
    }

    /**
     * This method outputs set with unique elements in the Collection <Message>
     *
     * @param messages - Set<Message>
     */
    private static void printSetMessage(Set<Message> messages) {
        for (Message message : messages) {
            String output = String.format(Locale.ROOT, "Massage from %s  with Text:  [ %s ] was delivered  at %s", message.remotePhoneNumber, message.textMassage, message.startDate.toString());
            System.out.println(output);
        }
    }

    /**
     * This method implements the text search function for the collection with contacts
     *
     * @param contacts - Collection<Contacts>
     * @param text     - search text
     * @return new Collection <Contact> with found contacts
     */
    private static Collection<Contact> findContacts(Collection<Contact> contacts, String text) {
        Collection<Contact> result = new ArrayList<>();
        result.addAll(filterCollection(contacts, contact -> contact.name.contains(text) || contact.phoneNumber.contains(text)));
        return result;
    }

    /**
     * This method implements the text search function for the collection with CallLogs
     *
     * @param callLogs - Collection<CallLog>
     * @param text     - search text
     * @return new Collection <CallLog> with found contacts
     */
    private static Collection<CallLog> findCalls(Collection<CallLog> callLogs, String text) {
        Collection<CallLog> result = new ArrayList<>();
        result.addAll(filterCollection(callLogs, callLog -> callLog.remotePhoneNumber.contains(text)));
        return result;
    }

    /**
     * This method implements the text search function for the collection with Messages
     *
     * @param messages - Collection<Message>
     * @param text     - search text
     * @return new Collection <Message> with found contacts
     */
    private static Collection<Message> findMessage(Collection<Message> messages, String text) {
        Collection<Message> result = new ArrayList<>();
        result.addAll(filterCollection(messages, message ->message.remotePhoneNumber.contains(text) || message.textMassage.contains(text))) ;
        return result;
    }

    /**
     * This method outputs Collection<Contact>
     *
     * @param contacts - Collection<Contact>
     */
    private static void printContacts(Collection<Contact> contacts) {
        for (Contact contact : contacts) {
            String output = String.format(Locale.ROOT, "Name of contact %s, his number -  %s", contact.name, contact.phoneNumber);
            System.out.println(output);
        }
    }

    /**
     * This method outputs Collection<CallLog>
     *
     * @param calls - Collection<CallLog>
     */
    private static void printCallLog(Collection<CallLog> calls) {
        for (CallLog callLog : calls) {

            String output = String.format(Locale.ROOT, "Call to %s, duration -  %d, at - %s", callLog.remotePhoneNumber, callLog.duration, callLog.startDate.toString());
            System.out.println(output);
        }
    }

    /**
     * This method outputs Collection<Message>
     *
     * @param messages - Collection<Message>
     */
    private static void printMassage(Collection<Message> messages) {
        for (Message message : messages) {
            String output = String.format(Locale.ROOT, "Massage from %s  with Text:  [ %s ] was delivered  at %s", message.remotePhoneNumber, message.textMassage, message.startDate.toString());
            System.out.println(output);
        }
    }

    /**
     * This method group Collection <Contact> to Map <String, Contact>, String - Contact phone number
     *
     * @param contacts - Collection<Contact>
     * @return new Map <String, Contact>, Key - Contact phone number, Contact - contact
     */
    private static Map<String, Contact> mapContactsToPhoneNumber(Collection<Contact> contacts) {
        Map<String, Contact> result = new HashMap<>();

        for (Contact contact : contacts) {
            result.put(contact.phoneNumber, contact);
        }

        return result;
    }

    /**
     * This method groups callLogs by contacts
     *
     * @param callLogs - Collection<Message>
     * @return Map<String, List < CallLog>> - grouped calls by contacts.
     */
    private static Map<String, List<CallLog>> groupCalls(Collection<CallLog> callLogs) {
        Map<String, List<CallLog>> result = new HashMap<>();

        for (CallLog callLog : callLogs) {
            List<CallLog> calls = result.get(callLog.remotePhoneNumber);

            if (calls == null) {
                // создать "группу" только если она отсутствует
                calls = new ArrayList<>();
                result.put(callLog.remotePhoneNumber, calls);
            }

            // добавить звонок в существующую группу или только созданную
            calls.add(callLog);
        }

        return result;
    }

    /**
     * This method outputs grouped calls by contacts.
     *
     * @param contacts -Map<String, Contact>
     * @param calls    - Map<String, List<CallLog>>
     */
    private static void printGroupCalls(Map<String, Contact> contacts, Map<String, List<CallLog>> calls) {
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            Contact contact = entry.getValue();

            System.out.println(contact.name + ":");

            List<CallLog> callLogs = calls.get(entry.getKey());
            for (int i = 0; i < callLogs.size(); i++) {

                CallLog callLog = callLogs.get(i);
                int minutes = callLog.duration / 60;
                int seconds = callLog.duration % 60;
                DateFormat format = DateFormat.getDateTimeInstance();

                String output = String.format(
                        "%d. %s / %dm %02ds",
                        i + 1,
                        format.format(callLog.startDate),
                        minutes,
                        seconds);
                System.out.println(output);
            }
        }
    }

    /**
     * This method groups messages by contacts
     *
     * @param messages - Collection<Message>
     * @return Map<String, List < Message>> - grouped messages by contacts.
     */
    private static Map<String, List<Message>> groupMessage(Collection<Message> messages) {
        Map<String, List<Message>> result = new HashMap<>();
        List<Integer> countMassage = new ArrayList<>();
        for (Message message : messages) {
            List<Message> messageList = result.get(message.remotePhoneNumber);
            if (messageList == null) {
                messageList = new ArrayList<>();
                result.put(message.remotePhoneNumber, messageList);
            }
            messageList.add(message);
            countMassage.add(messageList.size());
        }
        return result;
    }

    /**
     * This method outputs grouped messages by contacts.
     *
     * @param contacts -Map<String, Contact>
     * @param messages - Map<String, List<Message>>
     */
    private static void printGroupMessage(Map<String, Contact> contacts, Map<String, List<Message>> messages) {
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            Contact contact = entry.getValue();

            System.out.println(contact.name + ":");

            List<Message> messageList = messages.get(entry.getKey());
            for (int i = 0; i < messageList.size(); i++) {

                Message message = messageList.get(i);
                DateFormat format = DateFormat.getDateTimeInstance();

                String output = String.format(
                        "%d. Massage with Text:  [ %s ] was delivered  at %s",
                        i + 1, message.textMassage,
                        format.format(message.startDate)
                );
                System.out.println(output);
            }
        }
    }

    /**
     * This method sort top 5 contacts with the most quantity calls.
     *
     * @param contacts - Map <String, Contact>
     * @param calls-   Map<String, List<CallLog>>
     */
    private static List<Pair<Contact, Integer>> sortTopCallsContacts(Map<String, Contact> contacts, Map<String, List<CallLog>> calls) {
        List<Pair<Contact, Integer>> result = new ArrayList<>();
        for (Map.Entry<String, List<CallLog>> entry : calls.entrySet()) {
            String phoneNumber = entry.getKey();
            Integer callsCount = entry.getValue().size();
            Contact contact = contacts.get(phoneNumber);

            result.add(new Pair(contact, callsCount));
        }
        result.sort(new Comparator<Pair<Contact, Integer>>() {
            @Override
            public int compare(Pair<Contact, Integer> o1, Pair<Contact, Integer> o2) {
                return (o2.value - o1.value);
            }
        });
        return result;
    }

    /**
     * This method sort top 5 contacts with the most sum of duration.
     *
     * @param contacts - Map <String, Contact>
     * @param calls-   Map<String, List<CallLog>>
     */
    private static List<Pair<Contact, Integer>> sortTopDurations(Map<String, Contact> contacts, Map<String, List<CallLog>> calls) {
        List<Pair<Contact, Integer>> result = new ArrayList<>();
        for (Map.Entry<String, List<CallLog>> entry : calls.entrySet()) {
            String phoneNumber = entry.getKey();
            List<CallLog> call = entry.getValue();
            Integer durationSum = 0;
            for (CallLog callLog : call) {
                durationSum += callLog.duration;
            }
            Contact contact = contacts.get(phoneNumber);
            result.add(new Pair(contact, durationSum));
            result.sort(new Comparator<Pair<Contact, Integer>>() {
                @Override
                public int compare(Pair<Contact, Integer> o1, Pair<Contact, Integer> o2) {
                    return (o2.value - o1.value);
                }
            });
        }
        return result;
    }

    /**
     * This method sort top 5 contacts with the most quantity messages.
     *
     * @param contacts - Map <String, Contact>
     * @param messages - Map<String, List<Message>>
     */
    private static List<Pair<Contact, Integer>> sortTopMessageContacts(Map<String, Contact> contacts, Map<String, List<Message>> messages) {
        List<Pair<Contact, Integer>> result = new ArrayList<>();
        for (Map.Entry<String, List<Message>> entry : messages.entrySet()) {
            String phoneNumber = entry.getKey();
            Integer callsCount = entry.getValue().size();
            Contact contact = contacts.get(phoneNumber);

            result.add(new Pair(contact, callsCount));
        }
        result.sort(new Comparator<Pair<Contact, Integer>>() {
            @Override
            public int compare(Pair<Contact, Integer> o1, Pair<Contact, Integer> o2) {
                return (o2.value - o1.value);
            }
        });
        return result;
    }

    /**
     * This method print top5 of different sort list
     *
     * @param result - sorted list with pair Contact and Integer(for different sort). For example: Integer - quantity contact messages.
     */
    private static void printTop5Contacts(List<Pair<Contact, Integer>> result) {
        int count = Math.min(5, result.size());
        for (int i = 0; i < count; i++) {
            Pair<Contact, Integer> pair = result.get(i);
            String output = String.format("%20s %d", pair.key, pair.value);
            System.out.println(output);
        }
    }
}