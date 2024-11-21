import { View, Text, TouchableOpacity, Image, StyleSheet } from "react-native";
import { useRouter } from "expo-router";

const HomeScreen = () => {
  const router = useRouter();

  return (
    <View style={styles.container}>
      {/* Header */}
      <View style={styles.header}>
        <Image
          source={require("../assets/images/ic_vaccine.png")}
          style={styles.headerImage}
        />
        <Text style={styles.headerText}>Vacinação</Text>
      </View>
      <View style={styles.buttons}>
        {/* Calendário Button */}
        <TouchableOpacity
          style={styles.button}
          onPress={() => router.push("/calendario")}
        >
          <Image
            source={require("../assets/images/calendario.png")}
            style={styles.image}
          />
        </TouchableOpacity>

        <Text style={styles.buttonText}>Calendário</Text>
      </View>
      <View style={styles.buttons}>
        {/* Histórico Button */}
        <TouchableOpacity
          style={styles.button}
          onPress={() => router.push("/historico")}
        >
          <Image
            source={require("../assets/images/historico.png")}
            style={styles.image}
          />
          <Text style={styles.buttonText}>Histórico</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#FFFFFF",
    paddingTop: 20,
  },
  header: {
    backgroundColor: "#0066cc",
    paddingVertical: 20,
    paddingHorizontal: 10,
    flexDirection: "row",
    alignItems: "center",
    marginBottom: 20,
  },
  headerImage: {
    width: 40,
    height: 40,
    marginRight: 10,
  },
  headerText: {
    fontSize: 24,
    fontWeight: "bold",
    color: "#fff",
  },
  buttons: {
    padding: 20,
  },
  button: {
    alignItems: "center",
    backgroundColor: "#E2EAFF",
    padding: 10,
    borderRadius: 8,
    width: 50,
    height: 50,
  },
  image: {
    width: 30,
    height: 30,
  },
  buttonText: {
    fontSize: 14,
    color: "#000",
    marginTop: 10,
  },
});

export default HomeScreen;
