package maksym.preparation.medium.uf;

import maksym.preparation.util.Util;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       final int N = accounts.size();

       UF uf = new UF(N);
       Map<String, Integer> emailToId = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> record = accounts.get(i);
            String headEmail = record.get(1);

            emailToId.putIfAbsent(headEmail, i);
            int id = emailToId.get(headEmail);

            for (int j = 2; j < record.size(); j++) {
                String currEmail = record.get(j);

                emailToId.putIfAbsent(currEmail, i);
                int currId = emailToId.get(currEmail);

                uf.unit(id, currId);
            }
        }

        Set<String> visited = new HashSet<>();
        Map<Integer, List<String>> groupedEmails = new HashMap<>();
        Map<Integer, String> idToName = new HashMap<>();

        for (List<String> record : accounts) {
            String name = record.get(0);
            String headEmail = record.get(1);
            int id = uf.find(emailToId.get(headEmail));

            idToName.put(id, name);

            for (int i = 1; i < record.size(); i++) {
                String email = record.get(i);

                if (visited.add(email)) {
                    groupedEmails.computeIfAbsent(id, k -> new ArrayList<>()).add(email);
                }
            }
        }

        List<List<String>> merged = new ArrayList<>();

        for (Integer id : idToName.keySet()) {
            List<String> emails = groupedEmails.get(id);
            Collections.sort(emails);
            String name = idToName.get(id);

            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);

            merged.add(account);
        }

        return merged;
    }

    private static class UF {
        private final int[] arr;
        private final int[] rank;

        public UF(int n) {
            this.arr = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public int find(int n) {
            int v = arr[n];

            if (v != n) {
                arr[n] = find(v);
            }

            return arr[n];
        }

        private void unit(int n1, int n2) {
            int v1 = find(n1);
            int v2 = find(n2);

            if (v1 != v2) {
                int r1 = rank[v1];
                int r2 = rank[v2];

                if (r1 < r2) {
                    arr[v1] = arr[v2];
                } else if (r2 < r1) {
                    arr[v2] = arr[v1];
                } else {
                    arr[v2] = arr[v1];
                    rank[v1]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        AccountsMerge o = new AccountsMerge();

        var accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com")
        );

        Util.show2dList(o.accountsMerge(accounts));
    }
}
