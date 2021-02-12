package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.BDD.DataSourceConnexion;
import fr.spring.eBoutique.project.model.CartePaiement;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class CartePaiementDaoImpl implements ICartePaiementDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    private Connection connexion = null;

    public CartePaiementDaoImpl() {
        if (connexion == null) {
            try {
                connexion = DataSourceConnexion.getInstance().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //----------------------------------------------------------------------------
    @Override
    public CartePaiement getCartePaiment(Integer id) {

        CartePaiement cartePaiement = null;
        ResultSet rs = null;

        try {
            String requete = "SELECT * FROM cartepaiement WHERE id=?";
            PreparedStatement ps = connexion.prepareStatement(requete);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs != null && rs.next()) {
                cartePaiement = new CartePaiement();
                cartePaiement.setId(rs.getLong("id"));
                cartePaiement.setNumero(rs.getInt("numero"));
                cartePaiement.setDateValidite(LocalDate.parse(rs.getString("date_validite")));
                cartePaiement.setCryptogramme(rs.getInt("cryptograme"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        return cartePaiement;
    }

    //------------------------------------------------------------------------------------------
    @Override
    public List<CartePaiement> getCartesPaiment(Integer idUtilisateur) {

        List<CartePaiement> listecarteP = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM cartepaiement WHERE utilisateur_id=?";
            Statement stm = connexion.createStatement();
            rs = stm.executeQuery(query);

            if (rs != null) {
                listecarteP = new ArrayList<CartePaiement>();
                while (rs.next()) {
                    CartePaiement cartePaiement = new CartePaiement();

                    cartePaiement.setId(rs.getLong("id"));
                    cartePaiement.setNumero(rs.getInt("numero"));
                    cartePaiement.setDateValidite(LocalDate.parse(rs.getString("date_validite")));
                    cartePaiement.setCryptogramme(rs.getInt("cryptograme"));
                    listecarteP.add(cartePaiement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return listecarteP;
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public CartePaiement addCartePaiement(CartePaiement cartePaiement) {

        CartePaiement cartepaiementadded = null;

        try {
            String requete = "INSERT INTO cartepaiement (numero, date_validite, cryptograme) VALUES (?,?,?)";
            PreparedStatement ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, cartePaiement.getNumero());
            ps.setString(2, String.valueOf(cartePaiement.getDateValidite()));
            ps.setInt(3, cartePaiement.getCryptogramme());

            ps.executeUpdate();
            cartepaiementadded = cartePaiement;

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cartepaiementadded.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return cartepaiementadded;
    }

    //-----------------------------------------------------------------------------------------------
    @Override
    public void removeCartePaiement(Integer id) {

        try {
            String requete = "DELETE FROM cartepaiement Where id= ?";
            PreparedStatement ps = connexion.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public CartePaiement validate(String cartId) throws IOException {
        return null;
    }
}
