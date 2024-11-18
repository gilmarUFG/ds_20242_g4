import React, { useState } from "react";
import {
  View,
  Text,
  TextInput,
  Button,
  ScrollView,
  Image,
  StyleSheet,
  Dimensions,
} from "react-native";
import api from "../../utils/api";

const CalendarioScreen = () => {
  const [idade, setIdade] = useState("");
  const [activeCategory, setActiveCategory] = useState<string | null>(null);
  const [calendario, setCalendario] = useState<any>(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const determineCategory = (age: number) => {
    if (age >= 0 && age <= 10) return "Criança";
    if (age > 10 && age <= 19) return "Adolescente";
    if (age > 19 && age <= 59) return "Adulto";
    if (age >= 60) return "Idoso";
    return null;
  };

  const buscarCalendario = async () => {
    setIsLoading(true);
    setError(null);
    try {
      const ageNum = parseInt(idade);
      const category = determineCategory(ageNum);
      setActiveCategory(category);

      const response = await api.get("/calendario/vacinacao", {
        params: { idade },
      });
      setCalendario(response.data);
    } catch (err: any) {
      setError(err.message);
    } finally {
      setIsLoading(false);
    }
  };

  const getIconForCategory = (category: string) => {
    switch (category) {
      case "Criança":
        return require("../../assets/images/children_icon.png");
      case "Adolescente":
        return require("../../assets/images/teen_icon.png");
      case "Adulto":
        return require("../../assets/images/adult_icon.png");
      case "Idoso":
        return require("../../assets/images/elder_icon.png");
      default:
        return null;
    }
  };

  const renderCategoryScreen = (category: string) => {
    const categoryData = calendario?.filter(
      (item: any) => item.categoria === category
    );

    return (
      <View style={styles.categoryScreen}>
        <View style={styles.iconContainer}>
          <Image
            source={getIconForCategory(category)}
            style={styles.categoryIcon}
          />
          <Text style={styles.categoryTitle}>{`Vacinas ${category}`}</Text>
        </View>

        <ScrollView style={styles.vaccineList}>
          {categoryData?.map((item: any) => (
            <View key={item.calendarioId} style={styles.vaccineCard}>
              <Text style={styles.vaccineName}>{item.vacinas}</Text>
              <Text style={styles.vaccineInfo}>Doses: {item.doses}</Text>
              <Text style={styles.vaccineInfo}>
                Faixa Etária: {item.faixa_etaria.de} - {item.faixa_etaria.ate}
              </Text>
            </View>
          ))}
        </ScrollView>
      </View>
    );
  };

  return (
    <View style={styles.container}>
      {!activeCategory ? (
        <>
          <View style={styles.header}>
            <Image
              source={require("../../assets/images/calendar 1.png")}
              style={styles.headerImage}
            />
            <Text style={styles.headerTitle}>Calendário de Vacinação</Text>
          </View>

          <TextInput
            placeholder="Digite sua idade"
            keyboardType="numeric"
            onChangeText={setIdade}
            value={idade}
            style={styles.input}
          />
          <Button title="Buscar Calendário" onPress={buscarCalendario} />

          {isLoading && <Text>Carregando...</Text>}
          {error && <Text style={styles.errorText}>Erro: {error}</Text>}
        </>
      ) : (
        renderCategoryScreen(activeCategory)
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#001F3F",
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
  headerTitle: {
    color: "#fff",
    fontSize: 24,
    fontWeight: "bold",
  },
  input: {
    backgroundColor: "#fff",
    borderWidth: 1,
    borderColor: "#ccc",
    padding: 15,
    marginHorizontal: 20,
    marginVertical: 10,
    borderRadius: 8,
    fontSize: 16,
  },
  categoryScreen: {
    flex: 1,
    backgroundColor: "#001F3F",
  },
  iconContainer: {
    alignItems: "center",
    padding: 20,
  },
  categoryIcon: {
    width: 80,
    height: 80,
    marginBottom: 10,
  },
  categoryTitle: {
    color: "#fff",
    fontSize: 24,
    fontWeight: "bold",
    marginVertical: 10,
  },
  vaccineList: {
    flex: 1,
    padding: 20,
  },
  vaccineCard: {
    backgroundColor: "#003366",
    padding: 15,
    borderRadius: 10,
    marginBottom: 15,
  },
  vaccineName: {
    color: "#fff",
    fontSize: 18,
    fontWeight: "bold",
    marginBottom: 5,
  },
  vaccineInfo: {
    color: "#fff",
    fontSize: 16,
    marginVertical: 2,
  },
  bottomNav: {
    height: 60,
    backgroundColor: "#002147",
    justifyContent: "center",
    alignItems: "center",
  },
  bottomNavImage: {
    width: Dimensions.get("window").width,
    height: 60,
    resizeMode: "contain",
  },
  errorText: {
    color: "red",
    textAlign: "center",
    marginTop: 10,
  },
});

export default CalendarioScreen;
