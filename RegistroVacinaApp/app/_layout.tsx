import { Tabs } from 'expo-router';

export default function Layout() {
  return (
    <Tabs>
      <Tabs.Screen
        name="home"
        options={{
          title: 'Home',
        }}
      />
      <Tabs.Screen
        name="calendario"
        options={{
          title: 'Calendário',
        }}
      />
    </Tabs>
  );
}
