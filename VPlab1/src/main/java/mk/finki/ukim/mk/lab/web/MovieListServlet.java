package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.Service.MovieService;
import mk.finki.ukim.mk.lab.model.Movie;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;



import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {""})
@AllArgsConstructor
public class MovieListServlet extends HttpServlet {
    private final MovieService movieService;
    private final SpringTemplateEngine springTemplateEngine;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String newTitle = req.getParameter("title");
        String newSummary = req.getParameter("summary");
        String newRating = req.getParameter("rating");

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context =  new WebContext(webExchange);

        if (req.getParameter("numTickets") != null) {
            resp.sendRedirect("/ticketOrder");
        }else {
            context.setVariable("movies", movieService.listAll());
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String rating = req.getParameter("rating");


        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context =  new WebContext(webExchange);

        if (title != null && !title.isEmpty() && rating!=null && !rating.isEmpty())
        {
            double doublerating = Double.parseDouble(rating);
            List<Movie> filteredMovies = movieService.searchMovies(title).stream().filter(r->r.getRating()>=doublerating).toList();
            context.setVariable("movies", filteredMovies);
        } else
        {
            context.setVariable("movies", movieService.listAll());
        }

        springTemplateEngine.process("listMovies.html", context, resp.getWriter());

    }
}

